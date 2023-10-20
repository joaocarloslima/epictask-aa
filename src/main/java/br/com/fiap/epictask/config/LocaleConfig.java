package br.com.fiap.epictask.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class LocaleConfig {
    
    @Bean
    MessageSource messageSource(){
        var messageSource = new ResourceBundleMessageSource();
        messageSource.addBasenames("lang/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
