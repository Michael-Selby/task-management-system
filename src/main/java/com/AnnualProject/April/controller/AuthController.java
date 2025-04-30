package com.AnnualProject.April.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "hello"; // Directs to Thymeleaf login template
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof OAuth2User)) {
            return "No"; // Redirects to login if user is not authenticated
        }

        return "hi"; // Ensure it matches Thymeleaf template (`dashboard.html`)
 }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//
//        request.getSession().invalidate(); // Clear user session
//        return "redirect:/login"; // Redirect back to local login page after logout
//    }
}