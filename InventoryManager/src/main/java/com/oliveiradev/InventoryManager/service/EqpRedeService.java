package com.oliveiradev.InventoryManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiradev.InventoryManager.model.EqpRede;
import com.oliveiradev.InventoryManager.repository.EqpRedeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EqpRedeService {

    @Autowired
    private EqpRedeRepository eqpRedeRepository;

    // Salva ou atualiza o Equipamento de Rede, aplicando validações adicionais
    public EqpRede saveEqpRede(EqpRede eqpRede) {
        if (eqpRede == null || !eqpRede.isValid()) {
            throw new IllegalArgumentException("Dados do Equipamento de Rede são inválidos.");
        }
        return eqpRedeRepository.save(eqpRede);
    }

    // Retorna todos os Equipamentos de Rede
    public List<EqpRede> getAllEqpRedes() {
        return eqpRedeRepository.findAll();
    }

    // Retorna um Equipamento de Rede por ID
    public Optional<EqpRede> getEqpRedeById(Long id) {
        return eqpRedeRepository.findById(id);
    }

    // Deleta um Equipamento de Rede pelo ID, com tratamento de exceções
    public void deleteEqpRedeById(Long id) {
        if (!eqpRedeRepository.existsById(id)) {
            throw new IllegalArgumentException("Equipamento de Rede com ID " + id + " não encontrado.");
        }
        eqpRedeRepository.deleteById(id);
    }

    // Verifica se o Equipamento de Rede existe pelo ID
    public boolean existsById(Long id) {
        return eqpRedeRepository.existsById(id);
    }
}
