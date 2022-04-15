package ru.orangemaks.restaurant.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.orangemaks.restaurant.domain.user.registration.UserRegistrationInputBoundary;

/**
 * Security Configuration
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * For crypt password
     */
    BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * For config UserDetailsService
     */
    UserRegistrationInputBoundary userRegistrationInteractor;

    public WebSecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserRegistrationInputBoundary userRegistrationInteractor) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRegistrationInteractor = userRegistrationInteractor;
    }

    /**
     * Endpoint access configuration
     * @param httpSecurity object HttpSecurity for configuration security
     */
    @SneakyThrows
    @Override
    protected void configure(HttpSecurity httpSecurity)  {
        httpSecurity
                .csrf()
                    .disable()
                .cors()
                    .disable()
                .authorizeRequests()
                    //Доступ только для не зарегистрированных пользователей
                    .antMatchers("/registration").not().fullyAuthenticated()
                    //Доступ только для зарегистрированных пользователей
                    .antMatchers("/lk").fullyAuthenticated()
                    //Доступ только для пользователей с ролью Администратор
                    .antMatchers("/admin/**","/actuator/**").hasRole("ADMIN")
                    .antMatchers("/basket").hasRole("USER")
                    //Доступ разрешен всем пользователей
                    .antMatchers("/", "/resources/**","/css/**","/*").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                    //Настройка для входа в систему
                    .formLogin()
                    .loginPage("/login")
                    //Перенарпавление на главную страницу после успешного входа
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }

    /**
     * config default userDetailsService and encoder
     * @param auth object AuthenticationManagerBuilder for configuration default settings
     */
    @SneakyThrows
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth){
        auth.userDetailsService(userRegistrationInteractor).passwordEncoder(bCryptPasswordEncoder);
    }
}
