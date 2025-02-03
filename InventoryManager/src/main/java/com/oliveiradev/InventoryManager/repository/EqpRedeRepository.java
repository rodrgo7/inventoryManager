package com.oliveiradev.InventoryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oliveiradev.InventoryManager.model.EqpRede;

@Repository
public interface EqpRedeRepository extends JpaRepository<EqpRede, Long> {

}
