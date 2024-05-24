package com.daergaoth.svnhook.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

import java.util.function.Supplier;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/requestB").permitAll()
                        .requestMatchers("/api/svn-hook/post-commit").permitAll()
                        .requestMatchers("/api/test/ip").access(customAuthorizationManager())
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public AuthorizationManager<RequestAuthorizationContext> customAuthorizationManager() {
        return new CustomAuthorizationManager();
    }

    public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

        private final IpAddressMatcher ipAddressMatcher1 = new IpAddressMatcher("192.168.1.1");
        private final IpAddressMatcher ipAddressMatcher2 = new IpAddressMatcher("0:0:0:0:0:0:0:1");

        @Override
        public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
            String ipAddress = context.getRequest().getRemoteAddr();
            System.out.println("IP ADDRESS: " + ipAddress);
            boolean granted = ipAddressMatcher1.matches(ipAddress) || ipAddressMatcher2.matches(ipAddress);
            System.out.println("Granted: " + granted);
            boolean temp = true;
            return new AuthorizationDecision(temp);
        }
    }
}





