package com.springbootdev.springcloud.examples.springcloudconfigserver;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http.csrf().disable()
                         .httpBasic().and()
                         .authorizeRequests()
                         .requestMatchers(EndpointRequest.to("health","info","/bus-refresh")).permitAll()
                         .antMatchers("/**").authenticated();

    }


}

