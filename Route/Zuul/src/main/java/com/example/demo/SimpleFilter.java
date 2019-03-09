package com.example.demo;

/**
 * @author 谢天帝
 * @version v0.1 2017/6/12.
 */
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken==null || !accessToken.toString().equals("tiandi") ) {
            log.warn("access token is wrong");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("Token wrong! Ask tiandi for the right token!");
            return null;
        }
        log.info("access token ok");
        return null;
    }

}