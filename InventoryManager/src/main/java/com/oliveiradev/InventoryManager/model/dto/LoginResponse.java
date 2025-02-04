package com.oliveiradev.InventoryManager.model.dto;

import com.oliveiradev.InventoryManager.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private Role role;
    private String token;
}
