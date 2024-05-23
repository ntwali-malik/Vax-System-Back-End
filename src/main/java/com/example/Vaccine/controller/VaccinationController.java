package com.example.Vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vaccine.Dto.VaccineDto;
import com.example.Vaccine.Repository.VaccineRepository;
import com.example.Vaccine.entity.Vaccine;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Vaccine")
@CrossOrigin(origins = "http://localhost:3000")
public class VaccinationController {
	
	@Autowired
	private VaccineRepository repo;
	
	//Display all Vaccines
		@GetMapping("/all")
		public List<Vaccine> getAllVaccines(){
			return repo.findAll();
		}
		
		//Display Vaccine Based on ID
		@GetMapping("/{vaccineId}")
		public ResponseEntity<Object> getSoldier(@PathVariable Long soldierId) {
			   Vaccine vaccine = repo.findById(soldierId).orElse(null);
			    if (vaccine == null) {
			        return new ResponseEntity<>("Vaccine with ID " + soldierId + " not found", HttpStatus.NOT_FOUND);
			    } else {
			        return ResponseEntity.ok(vaccine);
			    }
			}
		
		//Saving A Vaccine
				@PostMapping
				@RequestMapping("/addVaccine")
				public ResponseEntity<Object> createSoldier(@Valid @RequestBody VaccineDto vaccineDto){
					
					Vaccine vaccine = new Vaccine();
					vaccine.setVaccineName(vaccineDto.getVaccineName());
					vaccine.setManufacturer(vaccineDto.getManufacturer());
					vaccine.setBatchNumber(vaccineDto.getBatchNumber());
					vaccine.setExpiryDate(vaccineDto.getExpiryDate());
					
					repo.save(vaccine);
					
					return ResponseEntity.ok(vaccine);
					
				}
				

				// UPDATING SOLDIER INFO
				
				@PutMapping("/{vaccineId}")
				public ResponseEntity<Object> updateSoldier(@PathVariable Long vaccineId, @Valid @RequestBody VaccineDto vaccineDto) {
				    // Retrieve the existing student from the repository
					Vaccine vaccine = repo.findById(vaccineId).orElse(null);
				    if (vaccine == null) {
				        return new ResponseEntity<>("Vaccine with ID " + vaccineId + " not found", HttpStatus.NOT_FOUND);
				    }
				    vaccine.setVaccineName(vaccineDto.getVaccineName());
					vaccine.setManufacturer(vaccineDto.getManufacturer());
					vaccine.setBatchNumber(vaccineDto.getBatchNumber());
					vaccine.setExpiryDate(vaccineDto.getExpiryDate());
					
				    repo.save(vaccine);
				    return ResponseEntity.ok(vaccine);
				}
				
				//DELETING SOLDIER INFO
				
				@DeleteMapping("/{vaccineId}")
				public ResponseEntity<Object> deleteSoldier (@PathVariable Long vaccineId){
					Vaccine vaccine = repo.findById(vaccineId).orElse(null);
				    if (vaccine == null) {
				        return new ResponseEntity<>("Vaccine with ID " + vaccineId + " not found", HttpStatus.NOT_FOUND);
				    }
				    
				    repo.delete(vaccine);
				    return ResponseEntity.status(HttpStatus.OK).body("Vaccine with id " + vaccineId + " deleted successfully");
					
				}

}
