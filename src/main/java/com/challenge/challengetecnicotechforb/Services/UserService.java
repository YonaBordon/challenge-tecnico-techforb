package com.challenge.challengetecnicotechforb.Services;

import com.challenge.challengetecnicotechforb.Entities.User;
import com.challenge.challengetecnicotechforb.Repositories.UserRepository;
import com.challenge.challengetecnicotechforb.Security.Payload.LoginRequest;
import com.challenge.challengetecnicotechforb.Security.Payload.MessageResponse;
import com.challenge.challengetecnicotechforb.Security.Payload.RegisterRequest;

import com.challenge.challengetecnicotechforb.Security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public MessageResponse registerUser(RegisterRequest request) {
        if (existsByUsername(request.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (existsByEmail(request.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        User user = new User(
            request.getUsername(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword())
        );
        userRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }

    public MessageResponse loginUser(LoginRequest request) {
        System.out.println(request.getUsername() + " " + request.getPassword());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);
        return new MessageResponse(token);
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
