package com.AnnualProject.April.serviceimplementaion;

import com.AnnualProject.April.model.User;
import com.AnnualProject.April.model.Role; // Ensure Role enum is imported
import com.AnnualProject.April.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    private static final List<String> ADMIN_EMAILS = List.of(
            "michaelselby200@gmail.com", "admin3@example.com"
    ); // Define multiple admin emails

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauthUser = super.loadUser(userRequest); // Corrected call

        // Extract attributes
        Map<String, Object> attributes = oauthUser.getAttributes();
        String email = (String) attributes.get("email");
        String fullname = (String) attributes.get("name");

        if (email == null) {
            throw new OAuth2AuthenticationException("Google did not return an email.");
        }

        Role assignedRole = ADMIN_EMAILS.contains(email) ? Role.ADMIN : Role.USER;

        // Save or retrieve user from database
        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setFullname(fullname != null ? fullname : "Unknown User");
            newUser.setRole(assignedRole); // Assign role based on email
            return userRepository.save(newUser);
        });

        return oauthUser;
    }
}