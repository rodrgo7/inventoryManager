package com.oliveiradev.InventoryManager.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EqpRede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    private String sigla;
    private String local;
    private String tipo;
    private String marca;
    private String modelo;
    private String portas;
    
    @NotBlank(message = "Número de série não pode ser vazio")
    private String numeroSerie;
    private String responsavel;
    private LocalDateTime dataAlteracao;

    // Método para garantir que a data de alteração nunca seja nula
    public void setDataAlteracao(LocalDateTime data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula!");
        }
        this.dataAlteracao = data;
    }

    // Validação de dados
    public boolean isValid() {
        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}