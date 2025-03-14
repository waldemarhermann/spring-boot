package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Hier wird festgelegt, dass jede HTTP-Anfrage (anyRequest()) eine Authentifizierung benötigt.
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders").hasRole("MANAGER")
                                .requestMatchers("/systems").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )

                .formLogin(form ->
                        form
                                // Spring Security zeigt nicht die Standard-Login-Seite an, sondern leitet Benutzer zu /showMyLoginPage.
                                // Gibt an, dass eine benutzerdefinierte Login-Seite (plain-login.html) verwendet wird.
                                .loginPage("/showMyLoginPage")

                                // Hier wird die Logik für die Login-Verarbeitung aktiviert.
                                // Wenn ein Benutzer auf "Login" klickt, sendet das Formular die Daten an /authenticateTheUser.
                                // Spring Security verarbeitet diese Daten automatisch, vergleicht sie mit gespeicherten Benutzern und entscheidet, ob der Login erfolgreich ist oder nicht.
                                .loginProcessingUrl("/authenticateTheUser")

                                // Jeder darf die Login-Seite aufrufen, selbst wenn er nicht eingeloggt ist.
                                .permitAll()
                )

                .logout(logout -> logout.permitAll()
                )

                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                );

        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails waldemar = User.builder()
                .username("waldemar")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails maxim = User.builder()
                .username("maxim")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails efimia = User.builder()
                .username("efimia")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(waldemar, maxim, efimia);
    }
     */
}
