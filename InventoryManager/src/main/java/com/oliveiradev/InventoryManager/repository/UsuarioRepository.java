package com.oliveiradev.InventoryManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveiradev.InventoryManager.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}