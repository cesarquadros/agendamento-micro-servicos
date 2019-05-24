package br.com.salasagendamento.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class GatewayFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        //System.out.println(ctx.get("serviceId"));
        HttpServletRequest request = ctx.getRequest();
        HttpSession session = request.getSession();
        String headerToken = request.getHeader("token");
        
        if(logado(session, headerToken)) {
        	ZuulException zuulException = new ZuulException("Realizar o LOGIN", HttpStatus.UNAUTHORIZED.value(), "Usuario não autorizado");
        	throw new ZuulRuntimeException(zuulException);
        }
		return true;
	}
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	public Boolean logado(HttpSession session, String token) {
		String tokenSession = (String) session.getAttribute(token);
		if(ObjectUtils.isEmpty(tokenSession)) {
			return false;
		}
		return true;
	}
}
