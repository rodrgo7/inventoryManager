package com.oliveiradev.InventoryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliveiradev.InventoryManager.model.Impressora;

@Repository
public interface ImpressoraRepository extends JpaRepository<Impressora, Long> {

}
