package com.oliveiradev.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Impressora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    private String sigla;
    private String local;
    private String tipo;
    private String marca;
    private String modelo;
    
    @NotBlank(message = "Número de série não pode ser vazio")
    private String numeroSerie;
    private String numeroPedido;
    private String responsavel;
    private LocalDateTime dataAlteracao;

    @PrePersist
    @PreUpdate
    public void updateDataAlteracao() {
        this.dataAlteracao = LocalDateTime.now();
    }

    // Validação de dados
    public boolean isValid() {
        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impressora that = (Impressora) o;
        return Objects.equals(idEquipamento, that.idEquipamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento);
    }
}
