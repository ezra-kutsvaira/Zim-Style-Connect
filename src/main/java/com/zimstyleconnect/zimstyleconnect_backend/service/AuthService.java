package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.dto.AuthResponse;
import com.zimstyleconnect.zimstyleconnect_backend.dto.LoginRequest;
import com.zimstyleconnect.zimstyleconnect_backend.dto.RegisterRequest;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Role;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import com.zimstyleconnect.zimstyleconnect_backend.repository.RoleRepository;
import com.zimstyleconnect.zimstyleconnect_backend.repository.UserRepository;
import com.zimstyleconnect.zimstyleconnect_backend.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Registers a new user with a default USER role.
     * Encodes password, assigns role, and returns JWT token.
     */
    public AuthResponse register(RegisterRequest request) {
        // Fetch default role from DB
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        //Create new user
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.getRoles().add(userRole);

        //Save to DB
        userRepository.save(user);

        //Generate JWT token
        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPasswordHash(),
                        user.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName()))
                                .toList()
                )
        );

        return new AuthResponse(token);
    }

    /**
     * Authenticates existing user and returns JWT token if valid.
     */
    public AuthResponse login(LoginRequest request) {
        //Authenticate user credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        //Fetch user details
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        //Generate JWT token
        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPasswordHash(),
                        user.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName()))
                                .toList()
                )
        );

        return new AuthResponse(token);
    }
}
