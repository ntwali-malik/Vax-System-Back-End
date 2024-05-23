package com.example.Vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Vaccine.Dto.InventoryDto;
import com.example.Vaccine.Repository.InventoryRepository;
import com.example.Vaccine.Repository.VaccineRepository;
import com.example.Vaccine.entity.Inventory;
import com.example.Vaccine.entity.Vaccine;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {
    
    @Autowired
    private InventoryRepository repo;
    
    @Autowired
    private VaccineRepository vaccineRepository;
    
    // Display all Inventory
    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return repo.findAll();
    }
    
    // Display Inventory based on ID
    @GetMapping("/{inventoryId}")
    public ResponseEntity<Object> getInventory(@PathVariable Long inventoryId) {
        Inventory inventory = repo.findById(inventoryId).orElse(null);
        if (inventory == null) {
            return new ResponseEntity<>("Inventory with ID " + inventoryId + " not found", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(inventory);
        }
    }
    
    // Saving an Inventory
    @PostMapping("/add")
    public ResponseEntity<Object> createInventory(@Valid @RequestBody InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setLocation(inventoryDto.getLocation());
        inventory.setQuantityAvailable(inventoryDto.getQuantityAvailable());
        inventory.setLastRestockDate(inventoryDto.getLastRestockDate());
        
        Vaccine vaccine = vaccineRepository.findById(inventoryDto.getVaccine())
                .orElseThrow(() -> new RuntimeException("Vaccine not found"));
        inventory.setVaccine(vaccine);
        
        repo.save(inventory);
        
        return ResponseEntity.ok(inventory);
    }
    
    // Update an existing Inventory
    @PutMapping("/update/{inventoryId}")
    public ResponseEntity<Object> updateInventory(@PathVariable Long inventoryId, @Valid @RequestBody InventoryDto inventoryDto) {
        Inventory existingInventory = repo.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        
        existingInventory.setLocation(inventoryDto.getLocation());
        existingInventory.setQuantityAvailable(inventoryDto.getQuantityAvailable());
        existingInventory.setLastRestockDate(inventoryDto.getLastRestockDate());
        
        Vaccine vaccine = vaccineRepository.findById(inventoryDto.getVaccine())
                .orElseThrow(() -> new RuntimeException("Vaccine not found"));
        existingInventory.setVaccine(vaccine);
        
        repo.save(existingInventory);
        
        return ResponseEntity.ok(existingInventory);
    }
    
    // Delete an existing Inventory
    @DeleteMapping("/delete/{inventoryId}")
    public ResponseEntity<Object> deleteInventory(@PathVariable Long inventoryId) {
        Inventory existingInventory = repo.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        
        repo.delete(existingInventory);
        
        return ResponseEntity.ok("Inventory with ID " + inventoryId + " has been deleted");
    }
}
