package com.example.rentacar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("h2")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .and()
                .withUser("client")
                .password(passwordEncoder().encode("1234"))
                .roles("CLIENT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()/*.anyRequest().authenticated()*/
                .antMatchers("/home").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers("/masini").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers("/angajati/**").hasRole("ADMIN")
                .antMatchers("/clienti/**").hasRole("ADMIN")
                .antMatchers("/masini/**").hasRole("ADMIN")
                .antMatchers("/chirie/**").hasRole("ADMIN")
                .antMatchers("/masina/**").hasRole("ADMIN")
                .antMatchers("/chirii/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/showLogInForm")
                .loginProcessingUrl("/authUser").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws
//            Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .and()
//                .withUser("client")
//                .password(passwordEncoder().encode("1234"))
//                .roles("CLIENT");
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()/*.anyRequest().authenticated()*/
//                .antMatchers("/home").hasAnyRole("CLIENT","ADMIN")
//                .antMatchers("/masini").hasAnyRole("CLIENT","ADMIN")
//                .antMatchers("/angajati/**").hasRole("ADMIN")
//                .antMatchers("/clienti/**").hasRole("ADMIN")
//                .antMatchers("/masini/**").hasRole("ADMIN")
//                .antMatchers("/chirie/**").hasRole("ADMIN")
//                .antMatchers("/masina/**").hasRole("ADMIN")
//                .antMatchers("/chirii/**").hasRole("ADMIN")
//                .and()
//                .formLogin().loginPage("/showLogInForm")
//                .loginProcessingUrl("/authUser").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access_denied");
//    }
//
//}
