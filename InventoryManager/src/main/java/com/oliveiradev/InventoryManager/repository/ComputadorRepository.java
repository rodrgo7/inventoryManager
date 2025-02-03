package com.oliveiradev.InventoryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliveiradev.InventoryManager.model.Computador;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Long> {

}
