package com.oliveiradev.InventoryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliveiradev.InventoryManager.model.Diversos;

@Repository
public interface DiversosRepository extends JpaRepository<Diversos, Long> {

}
