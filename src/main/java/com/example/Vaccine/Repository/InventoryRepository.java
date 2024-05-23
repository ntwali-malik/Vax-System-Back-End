package com.example.Vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vaccine.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
