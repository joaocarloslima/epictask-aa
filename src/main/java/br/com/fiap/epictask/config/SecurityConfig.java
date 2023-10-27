package br.com.fiap.epictask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

import br.com.fiap.epictask.user.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    UserRepository userRepository;
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .oauth2Login( Customizer.withDefaults() )
            .addFilterBefore(new LoginFilter(userRepository), OAuth2LoginAuthenticationFilter.class)
            .build();
    }

}
