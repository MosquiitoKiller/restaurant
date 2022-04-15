package ru.orangemaks.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration Beans
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    /**
     * Config BCryptPasswordEncoder bean
     * @return BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
