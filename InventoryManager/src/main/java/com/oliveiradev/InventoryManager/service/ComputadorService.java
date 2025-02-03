package com.oliveiradev.InventoryManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.oliveiradev.InventoryManager.model.Computador;
import com.oliveiradev.InventoryManager.repository.ComputadorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComputadorService {

    @Autowired
    private ComputadorRepository computadorRepository;

    // Método para criar um computador
    public Computador createComputador(Computador computador) {
        computador.setDataAlteracao(LocalDateTime.now());
        return computadorRepository.save(computador);
    }

    // Método para obter todos os computadores sem paginação
    public List<Computador> getComputadores() {
        return computadorRepository.findAll();
    }

    // Método para atualizar um computador
    public Computador updateComputador(Long id, Computador computador) {
        computador.setIdEquipamento(id);
        computador.setDataAlteracao(LocalDateTime.now());
        return computadorRepository.save(computador);
    }

    // Método para obter um computador por ID
    public Optional<Computador> getComputadorById(Long id) {
        return computadorRepository.findById(id);
    }

    // Método para deletar um computador por ID
    public void deleteComputadorById(Long id) {
        computadorRepository.deleteById(id);
    }

    // Método para obter computadores com paginação
    public Page<Computador> getPage(Integer pageSize, Integer pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return computadorRepository.findAll(pageRequest);
    }
}
