package com.mlink.error;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/16
 * @Description
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes{

    public static final Integer AUTH_CODE = 401;

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        RequestContext currentContext = RequestContext.getCurrentContext();
        if(AUTH_CODE.equals(currentContext.getResponseStatusCode())){
            errorAttributes.put("status",AUTH_CODE);
            errorAttributes.put("exception",currentContext.getResponseBody().toString());
            errorAttributes.remove("error");
            errorAttributes.put("message",currentContext.getResponseBody().toString());
        }
        return errorAttributes;
    }
}
