/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public Jwtauthfilter jwtAuthenticationFilter() {
        return new Jwtauthfilter();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/users","/persons","/token", "/")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .csrf().disable()
        .addFilterBefore(jwtAuthenticationFilter(), 
                UsernamePasswordAuthenticationFilter.class);
    }
}