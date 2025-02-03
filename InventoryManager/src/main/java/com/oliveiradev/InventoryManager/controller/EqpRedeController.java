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

import com.oliveiradev.InventoryManager.model.EqpRede;
import com.oliveiradev.InventoryManager.service.EqpRedeService;

@RestController
@RequestMapping("/eqpRedes")
public class EqpRedeController {

    @Autowired
    private EqpRedeService eqpRedeService;

    // Criar ou Atualizar um Equipamento de Rede
    @PostMapping
    public ResponseEntity<EqpRede> createOrUpdate(@RequestBody EqpRede eqpRede) {
        if (eqpRede == null || !eqpRede.isValid()) {
            return ResponseEntity.badRequest().build(); // Retorna 400 em caso de dados inválidos
        }

        EqpRede eqpRedeSalvo = eqpRedeService.saveEqpRede(eqpRede);
        return ResponseEntity.status(HttpStatus.CREATED).body(eqpRedeSalvo); // Retorna 201 em criação
    }
    
    // Listar todos os Equipamentos de Rede
    @GetMapping
    public ResponseEntity<List<EqpRede>> getAllEqpRedes() {
        List<EqpRede> eqpRedes = eqpRedeService.getAllEqpRedes();
        return ResponseEntity.ok(eqpRedes); // Retorna 200 OK
    }

    // Buscar um Equipamento de Rede pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<EqpRede> getEqpRedeById(@PathVariable Long id) {
        Optional<EqpRede> eqpRede = eqpRedeService.getEqpRedeById(id);
        return eqpRede.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar um Equipamento de Rede pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEqpRedeById(@PathVariable Long id) {
        // Verifica se o equipamento de rede existe antes de tentar deletar
        if (!eqpRedeService.existsById(id)) {
            return ResponseEntity.notFound().build(); // Retorna 404 caso o equipamento não exista
        }

        eqpRedeService.deleteEqpRedeById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após deletar
    }
}
