package com.oliveiradev.InventoryManager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oliveiradev.InventoryManager.model.Impressora;
import com.oliveiradev.InventoryManager.repository.ImpressoraRepository;

@Service
public class ImpressoraService {

    @Autowired
    private ImpressoraRepository impressoraRepository;

    public Impressora saveImpressora(Impressora impressora) {
        impressora.setDataAlteracao(LocalDateTime.now());
        return impressoraRepository.save(impressora);
    }

    public List<Impressora> getAllImpressora() {
        return impressoraRepository.findAll();
    }

    public Page<Impressora> getImpressorasPage(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return impressoraRepository.findAll(pageable);
}

    public Optional<Impressora> getImpressoraById(Long id) {
        return impressoraRepository.findById(id);
    }

    public void deleteImpressoraById(Long id) {
        impressoraRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return impressoraRepository.existsById(id);
    }
}
