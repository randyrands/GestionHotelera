package com.terry.authorization.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.terry.authorization.dto.LoginRequest;
import com.terry.authorization.dto.UserRequest;
import com.terry.authorization.dto.UserResponse;
import com.terry.authorization.services.AuthService;
import com.terry.authorization.services.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) throws Exception {
        String token = authService.authenticate(request.username(), request.password());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin/usuarios")
    public ResponseEntity<Set<UserResponse>> listarUsuarios() {
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @PostMapping("/admin/usuarios")
    public ResponseEntity<UserResponse> crearUsuario(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.crearUsuario(request));
    }

    @DeleteMapping("/admin/usuarios/{username}")
    public ResponseEntity<UserResponse> eliminarUsuario(@Valid @RequestBody String username) {
        return ResponseEntity.ok(userService.eliminarUsuario(username));
    }
}
