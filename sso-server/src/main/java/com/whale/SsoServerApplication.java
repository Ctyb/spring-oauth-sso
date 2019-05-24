package com.whale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author ljy
 * @version V1.0
 * @Package com.whale.sso.server
 * @Description: TODO
 * @date 2019/5/24 0024 9:30
 */

@SpringBootApplication
@RestController
public class SsoServerApplication{

    public static void main(String[] args) {

        SpringApplication.run(SsoServerApplication.class,args);

    }

    @GetMapping("/hello")
    public String hello(){
        return "hello 认证服务器";
    }
}
