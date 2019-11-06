package br.com.salasagendamento.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class GatewayFilter extends ZuulFilter {

	private Logger LOG = LoggerFactory.getLogger(GatewayFilter.class);

	private static final String USUARIO_NAO_AUTORIZADO = "Usuario não autorizado";
	private static final String REALIZAR_O_LOGIN = "Realizar o LOGIN";
	private static final String PRE = "pre";
	private static final String TOKEN = "token";

	private static final String SERVICO_CLIENTE = "cliente";

	private static final String METHOD_POST = "POST";
	
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		LOG.info(">>>>>>>>>>>>>>>>>>>>> Acessando Zuul");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		if (precisaAutenticar(request)) {
			verificaSessao(request);
		}
		return true;
	}

	public Boolean precisaAutenticar(HttpServletRequest request) {
		StringBuffer urlBuffer = request.getRequestURL();
		String url[] = urlBuffer.toString().split("/");
		String servicoSolicitado = url[url.length - 1];
		String method = request.getMethod();

		if (servicoSolicitado.equalsIgnoreCase(SERVICO_CLIENTE) && method.equalsIgnoreCase(METHOD_POST)) {
			return false;
		}
		return true;
	}

	public void verificaSessao(HttpServletRequest request) {
		LOG.info("Recuperando TOKEN do cabeçalho");
		String headerToken = request.getHeader(TOKEN);
		LOG.info("Token recuperado do cabeçalho: {}", headerToken);

		if (ObjectUtils.isEmpty(headerToken) || !verificaToken(headerToken)) {
			LOG.info(">>>>>>>>>>>>>>>>>>>>>>> TOKEN INEXISTENTE OU INVALIDO");
			ZuulException zuulException = new ZuulException(REALIZAR_O_LOGIN, HttpStatus.UNAUTHORIZED.value(),
					USUARIO_NAO_AUTORIZADO);
			throw new ZuulRuntimeException(zuulException);
		}
	}

	public Boolean verificaToken(String token) {
		LOG.info("Verificando se TOKEN é valido");
		String tokenExistente = redisTemplate.opsForValue().get(token);
		if (ObjectUtils.isEmpty(tokenExistente)) {
			LOG.info("TOKEN não é valido");
			return false;
		}
		LOG.info("TOKEN é valido");
		return true;
	}

	@Override
	public String filterType() {
		return PRE;
	}

	@Override
	public int filterOrder() {
		return 1;
	}
}
