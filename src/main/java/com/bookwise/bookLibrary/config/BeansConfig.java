package com.bookwise.booklibrary.config;

import com.bookwise.booklibrary.external.User.ExternalUserApi;
import com.bookwise.booklibrary.external.User.UserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public UserApi initExternalUserClient() {
        return new ExternalUserApi();
    }
}
