package com.mlink.configurer.oauth2.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author lsh
 * @version 2018/6/26
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {
    private String code;
    private String msg;
    private long time = System.currentTimeMillis();

    public CustomOauthException(OAuth2Exception oauth2Exception){
        super(oauth2Exception.getMessage(),oauth2Exception);
        this.code = oauth2Exception.getOAuth2ErrorCode();
        this.msg = oauth2Exception.getMessage();
    }
    public CustomOauthException(String code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
