package com.oliveiradev.InventoryManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiradev.InventoryManager.model.Impressora;
import com.oliveiradev.InventoryManager.service.ImpressoraService;

@RestController
@RequestMapping("/impressoras")
public class ImpressoraController {

    @Autowired
    private ImpressoraService impressoraService;

    // Criar um novo computador
    @PostMapping 
    public ResponseEntity<Impressora> createImpressora(@RequestBody Impressora impressora) {
        if (impressora.getIdEquipamento() != null) {
            return ResponseEntity.badRequest().body(null); // Devolve erro se o ID já estiver presente
        }
        Impressora impressoraSalvo = impressoraService.saveImpressora(impressora);
        return ResponseEntity.status(HttpStatus.CREATED).body(impressoraSalvo);
    }

    // Método para buscar impressoras com paginação
    public ResponseEntity<Page<Impressora>> getAllImpressora(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam(defaultValue = "10") int size) {
    Page<Impressora> impressoras = impressoraService.getImpressorasPage(currentPage, size);
    return new ResponseEntity<>(impressoras, HttpStatus.OK);
}

    // Atualizar uma impressora
    @PutMapping("/{id}")
    public ResponseEntity<Impressora> updateImpressora(@PathVariable Long id, @RequestBody Impressora impressora) {
        if (!impressoraService.existsById(id)) {
        return ResponseEntity.notFound().build();  // Devolve erro se o item não existir
    }
        impressora.setIdEquipamento(id);  // Atualiza o ID no objeto
        Impressora impressoraAtualizada = impressoraService.saveImpressora(impressora);
        return ResponseEntity.ok(impressoraAtualizada);
    }
}
