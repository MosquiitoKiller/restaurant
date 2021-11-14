package ru.orangemaks.restaurant.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("Login/login");
        registry.addViewController("/registration").setViewName("Login/registration");
        registry.addViewController("/admin").setViewName("Admin/admin");
        registry.addViewController("/menu").setViewName("menu");
    }
}
