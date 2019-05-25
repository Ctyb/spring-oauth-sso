package com.whale.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljy
 * @version V1.0
 * @Package PACKAGE_NAME
 * @Description: TODO
 * @date 2019/5/24 0024 10:53
 */

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SsoClient2Application  {

    public static void main(String[] args) {
        SpringApplication.run(SsoClient2Application.class,args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication user){
        return user;
    }

}
