package com.oliveiradev.InventoryManager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.oliveiradev.InventoryManager.model.Computador;
import com.oliveiradev.InventoryManager.service.ComputadorService;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/computadores")
@Validated 
public class ComputadorController {

    @Autowired
    private ComputadorService computadorService;

    @PostMapping
    public ResponseEntity<Computador> createComputador(@Valid @RequestBody Computador computador) {
        Computador computadorSalvo = computadorService.createComputador(computador);
        return new ResponseEntity<>(computadorSalvo, HttpStatus.CREATED);
    }

    // Método para buscar computadores com paginação
    @GetMapping
    public ResponseEntity<Page<Computador>> getAllComputadores(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<Computador> computadoresPage = computadorService.getPage(pageSize, currentPage);
        return new ResponseEntity<>(computadoresPage, HttpStatus.OK);
    }

    // Atualizar um computador
    @PutMapping("/{id}")
    public ResponseEntity<Computador> updateComputador(
            @PathVariable @Positive Long id, 
            @Valid @RequestBody Computador computador) {
        Computador computadorAtualizado = computadorService.updateComputador(id, computador);
        return new ResponseEntity<>(computadorAtualizado, HttpStatus.OK);
    }

    // Buscar um computador pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Computador> getComputadorById(@PathVariable @Positive Long id) {
        Optional<Computador> computador = computadorService.getComputadorById(id);
        return computador.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Excluir um computador pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComputadorById(@PathVariable @Positive Long id) {
        computadorService.deleteComputadorById(id);
        return ResponseEntity.noContent().build();
    }
    
}