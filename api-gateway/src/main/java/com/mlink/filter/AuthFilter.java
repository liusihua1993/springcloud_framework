package com.mlink.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/17
 * @Description
 * 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求头不包含 Authorization参数值，直接拦截不再路由
 */
@Component
public class AuthFilter extends ZuulFilter {
    public static final String OAUTH_TOKEN = "/oauth/token";
    private static Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    /**
     * 过滤器的类型 pre表示请求在路由之前被过滤
     * @return 类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return 顺序 数字越大表示优先级越低，越后执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否会被执行
     * @return true
     */
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestURI = request.getRequestURI();
        if(requestURI.contains(OAUTH_TOKEN)){
            return false;
        }
        return true;
    }

    /**
     * 过滤逻辑
     * @return 过滤结果
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getHeader("Authorization");
        if (accessToken==null){
            logger.warn("Authorization token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("Authorization token is empty");
            throw new RuntimeException("Authorization token is empty");
        }
        logger.info("Authorization token is ok");
        return null;
    }


}

