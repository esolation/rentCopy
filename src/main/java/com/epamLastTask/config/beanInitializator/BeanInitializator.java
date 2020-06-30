package com.epamLastTask.config.beanInitializator;

import com.epamLastTask.utils.RefererRedirectionAuthenticationSuccessHandler;
import com.epamLastTask.utils.RequestURI;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class BeanInitializator {

    @Bean
    public PasswordEncoder getPassEnc(){
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public Logger getLogger(){

        return Logger.getLogger("D:\\javaProjects\\SpringBootPratic\\rentCopy\\src\\main\\resources\\log4j.properties");
    }

    @Bean
    public RefererRedirectionAuthenticationSuccessHandler getRefererRedirect(){
        return new RefererRedirectionAuthenticationSuccessHandler();
    }

    @Bean
    public RequestURI getRequestURI(){
        return new RequestURI();
    }
    }

