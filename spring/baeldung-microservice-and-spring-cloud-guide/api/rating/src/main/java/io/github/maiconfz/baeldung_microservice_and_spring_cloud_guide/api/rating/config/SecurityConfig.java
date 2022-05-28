package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String API_URL_BASE_RATINGS = "/api/ratings";

    @Autowired
    public void configureGlobal1(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .authorizeRequests()
                .regexMatchers("^" + API_URL_BASE_RATINGS + "\\?bookId.*$").authenticated()
                .antMatchers(HttpMethod.GET, API_URL_BASE_RATINGS).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, API_URL_BASE_RATINGS).authenticated()
                .antMatchers(HttpMethod.PATCH, API_URL_BASE_RATINGS + "/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, API_URL_BASE_RATINGS + "/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable();
    }
}
