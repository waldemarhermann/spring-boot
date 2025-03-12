package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails waldemar = User.builder()
                .username("waldemar")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails maxim = User.builder()
                .username("maxim")
                .password("test123")
                .roles("EMPLOYEE, MANAGER")
                .build();

        UserDetails efimia = User.builder()
                .username("efimia")
                .password("test123")
                .roles("EMPLOYEE, MANAGER, ADMIN")
                .build();

        return new InMemoryUserDetailsManager(waldemar, maxim, efimia);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Hier wird festgelegt, dass jede HTTP-Anfrage (anyRequest()) eine Authentifizierung benötigt.
        http.authorizeHttpRequests(configurer ->
                        configurer
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
                );

        return http.build();
    }
}
