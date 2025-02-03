package com.oliveiradev.InventoryManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiradev.InventoryManager.model.Diversos;
import com.oliveiradev.InventoryManager.service.DiversosService;

@RestController
@RequestMapping("/diversos")
public class DiversosController {

    @Autowired
    private DiversosService diversosService;

    // Criar ou Atualizar um Diverso
    @PostMapping
    public ResponseEntity<Diversos> createOrUpdate(@RequestBody Diversos diversos) {
        if (diversos == null || !diversos.isValid()) {
            return ResponseEntity.badRequest().build(); // Retorna 400 em caso de dados inválidos
        }

        Diversos diversoSalvo = diversosService.saveDiversos(diversos);
        return ResponseEntity.status(HttpStatus.CREATED).body(diversoSalvo); // Retorna 201 em criação
    }

    // Listar todos os Diversos
    @GetMapping
    public ResponseEntity<List<Diversos>> getAllDiversos() {
        List<Diversos> diversos = diversosService.getAllDiversos();
        return ResponseEntity.ok(diversos); // Retorna 200 OK
    }

    // Buscar um Diverso pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Diversos> getDiversosById(@PathVariable Long id) {
        Optional<Diversos> diversos = diversosService.getDiversosById(id);
        return diversos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar um Diverso pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiversosById(@PathVariable Long id) {
        try {
            diversosService.deleteDiversosById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content após deletar
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o item não existir
        }
    }
}
