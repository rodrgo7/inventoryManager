package com.oliveiradev.InventoryManager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiradev.InventoryManager.model.Diversos;
import com.oliveiradev.InventoryManager.repository.DiversosRepository;

@Service
public class DiversosService {

    @Autowired
    private DiversosRepository diversosRepository;

    // Salvar ou Atualizar um Diverso
    public Diversos saveDiversos(Diversos diversos) {
        if (diversos == null || !diversos.isValid()) {
            throw new IllegalArgumentException("Dados inválidos para o Diverso.");
        }

        // Definindo a data de alteração para agora
        diversos.setDataAlteracao(LocalDateTime.now());
        return diversosRepository.save(diversos);
    }

    // Obter todos os Diversos
    public List<Diversos> getAllDiversos() {
        return diversosRepository.findAll();
    }

    // Obter um Diverso pelo ID
    public Optional<Diversos> getDiversosById(Long id) {
        return diversosRepository.findById(id);
    }

    // Deletar um Diverso pelo ID
    public void deleteDiversosById(Long id) {
        // Verifica se o ID existe no banco de dados
        if (!diversosRepository.existsById(id)) {
            throw new IllegalArgumentException("Diverso com ID " + id + " não encontrado.");
        }

        // Deleta o Diverso caso o ID exista
        diversosRepository.deleteById(id);
    }
}
