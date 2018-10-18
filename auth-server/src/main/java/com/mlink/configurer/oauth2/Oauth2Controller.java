package com.mlink.configurer.oauth2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author lsh
 */
@RestController
public class Oauth2Controller {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
