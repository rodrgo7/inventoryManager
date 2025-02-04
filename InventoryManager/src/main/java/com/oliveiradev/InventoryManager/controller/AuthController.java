package com.oliveiradev.InventoryManager.controller;

import com.oliveiradev.InventoryManager.model.Usuario;
import com.oliveiradev.InventoryManager.model.dto.LoginRequest;
import com.oliveiradev.InventoryManager.model.dto.LoginResponse;
import com.oliveiradev.InventoryManager.repository.UsuarioRepository;
import com.oliveiradev.InventoryManager.infra.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // Permite requisições do frontend
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();

        return ResponseEntity.ok(new LoginResponse(usuario.getUsername(), usuario.getRole(), token));
    }
}
