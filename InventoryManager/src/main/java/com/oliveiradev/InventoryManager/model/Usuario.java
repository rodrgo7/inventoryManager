package com.oliveiradev.InventoryManager.model;

import javax.validation.constraints.NotBlank;

import com.oliveiradev.InventoryManager.model.enums.Role;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Usuario não pode ser vazio")
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    // Validação de dados
    public boolean isValid() {
        return username != null && !username.trim().isEmpty();
    }
}
