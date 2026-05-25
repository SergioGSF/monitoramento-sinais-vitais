package br.com.projeto.arenapernambuco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/login",
                    "/cadastro",
                    "/events",
                    "/compra/**",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                .requestMatchers("/empresa/**")
                .hasRole("EMPRESA")

                .requestMatchers("/gestor/**")
                .hasRole("GESTOR")

                .anyRequest()
                .authenticated()
            )

            .formLogin(login -> login
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(successHandler())
                .permitAll()
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/events")
            );

        return http.build();
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler successHandler() {

        SavedRequestAwareAuthenticationSuccessHandler handler =
                new SavedRequestAwareAuthenticationSuccessHandler();

        handler.setDefaultTargetUrl("/events");

        return handler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}