package com.AnnualProject.April.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//
//    private final ClientRegistrationRepository clientRegistrationRepository;
//
//    public SecurityConfig(ClientRegistrationRepository clientRegistrationRepository) {
//        this.clientRegistrationRepository = clientRegistrationRepository;
//    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(auth->auth.requestMatchers("/").permitAll().anyRequest().authenticated()
                )
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();

    }

//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return (request, response, authentication) -> {
//            OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
//            String email = oauthUser.getAttribute("email");
//
//            Set<String> adminEmails = Set.of("michaelselby200@gmail.com", "admin2@example.com");
//
//            // Redirect admins to user management, others to dashboard
//            if (email != null && adminEmails.contains(email)) {
//                response.sendRedirect("/admin/users");
//            } else {
//                response.sendRedirect("/dashboard");
//            }
//        };
//    }
//
//    @Bean
//    public OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
//        OidcClientInitiatedLogoutSuccessHandler handler =
//                new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
//        handler.setPostLogoutRedirectUri("http://localhost:8087/login"); // Redirect after logout
//        return handler;
//    }
//
//    @Bean
//    public LogoutHandler logoutHandler() {
//        return (request, response, authentication) -> {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//            request.getSession().invalidate(); // Fully clears session
//        };
//    }
}