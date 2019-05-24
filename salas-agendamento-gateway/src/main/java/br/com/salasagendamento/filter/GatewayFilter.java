package br.com.salasagendamento.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

public class GatewayFilter extends ZuulFilter{
	
	private Logger LOG = LoggerFactory.getLogger(GatewayFilter.class);

	private static final String USUARIO_NAO_AUTORIZADO = "Usuario não autorizado";
	private static final String REALIZAR_O_LOGIN = "Realizar o LOGIN";
	private static final String PRE = "pre";
	private static final String TOKEN = "token";
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String headerToken = request.getHeader(TOKEN);
        
        LOG.info("Token recuperado do cabeçalho: " + headerToken);
        
        if(!logado(headerToken)) {
        	ZuulException zuulException = new ZuulException(REALIZAR_O_LOGIN, HttpStatus.UNAUTHORIZED.value(), USUARIO_NAO_AUTORIZADO);
        	throw new ZuulRuntimeException(zuulException);
        }
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

	public Boolean logado(String token) {
		String tokenExistente = redisTemplate.opsForValue().get(token);
		if(ObjectUtils.isEmpty(tokenExistente)) {
			return false;
		}
		return true;
	}
}
