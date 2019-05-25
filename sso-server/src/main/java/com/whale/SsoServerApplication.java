package com.whale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
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

@EnableResourceServer  //资源服务器
@SpringBootApplication
@RestController
public class SsoServerApplication{

    public static void main(String[] args) {

        SpringApplication.run(SsoServerApplication.class,args);

    }

    /**
     * 资源服务器提供的受保护接口
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello 资源服务器";
    }
}
