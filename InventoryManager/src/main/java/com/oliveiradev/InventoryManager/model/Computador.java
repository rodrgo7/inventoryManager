package com.oliveiradev.InventoryManager.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    private String sigla;
    private String local;
    private String nome;
    private String contato;
    private String ramal;
    private String marca;
    private String modelo;

    @NotBlank(message = "Número de série não pode ser vazio")
    private String numeroSerieCpu;
    private String processador;
    private String marcaMonitor; 
    private String numeroSerieMonitor;
    private Double tamanho;
    private String teclado;
    private String numeroSerieTeclado;
    private String mouse;
    private String numeroSerieMouse;
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
        return numeroSerieCpu != null && !numeroSerieCpu.trim().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computador that = (Computador) o;
        return Objects.equals(idEquipamento, that.idEquipamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento);
    }

    // Método para garantir que a data de alteração seja sempre configurada
    @PrePersist
    @PreUpdate
    public void updateDataAlteracao() {
        this.dataAlteracao = LocalDateTime.now();
    }
}
