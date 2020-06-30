package com.epamLastTask.config;

import com.epamLastTask.service.impl.UserServiceImpl;
import com.epamLastTask.utils.RefererRedirectionAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement

public class WebSecureConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RefererRedirectionAuthenticationSuccessHandler handler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/","/static/**","/img/**", "/hello", "/order/*").permitAll()
                .antMatchers("/login","/registration").anonymous()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                .successHandler(handler)
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/hello")
                .and()
                    .logout()
                .logoutSuccessUrl("/hello")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userServiceImpl)
                .passwordEncoder(passwordEncoder);

    }
}
