package com.whale.sso.server;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ljy
 * @version V1.0
 * @Package com.whale.security.browser
 * @Description: TODO
 * @date 2019/4/6 0006 19:22
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//    @Qualifier("inMemoryUserDetailsManager")
//    @Qualifier("ssoUserDetailsService")
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置用户名密码，这里采用内存方式，生产环境需要从数据库获取
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("123"))
                .roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()   //指定身份认证的方式为表单登录
//                .and()
//                .authorizeRequests() //对请求授权
//                .anyRequest()        //任何请求
//                .authenticated()    //安全认证
//                .and().csrf().disable().cors().disable();
//                .userDetailsService(userDetailsService);

        http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()	// 自定义登录页面，这里配置了 loginPage, 就会通过 LoginController 的 login 接口加载登录页面
                .and().csrf().disable().cors().disable();
    }
}

