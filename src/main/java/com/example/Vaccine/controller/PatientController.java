package com.example.Vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vaccine.Dto.PatientDto;
import com.example.Vaccine.Repository.PatientRepository;
import com.example.Vaccine.entity.Patient;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

	@Autowired
	private PatientRepository repo;
	
	//Display all Patients
		@GetMapping("/all")
		public List<Patient> getAllPatient(){
			return repo.findAll();
		}
		
		//Display Patient Based on ID
		@GetMapping("/{patientId}")
		public ResponseEntity<Object> getSoldier(@PathVariable Long patientId) {
			Patient patient = repo.findById(patientId).orElse(null);
			    if (patient == null) {
			        return new ResponseEntity<>("Patient with ID " + patientId + " not found", HttpStatus.NOT_FOUND);
			    } else {
			        return ResponseEntity.ok(patient);
			    }
			}
		
		//Saving A Patient
				@PostMapping
				@RequestMapping("/addPatient")
				public ResponseEntity<Object> createSoldier(@Valid @RequestBody PatientDto patientDto){
					
					Patient patient = new Patient();
					patient.setFirstName(patientDto.getFirstName());
					patient.setLastName(patientDto.getLastName());
					patient.setDob(patientDto.getDob());
					patient.setContactInfo(patientDto.getContactInfo());
					
					repo.save(patient);
					
					return ResponseEntity.ok(patient);
					
				}
				
				// UPDATING Patient INFO
				
				@PutMapping("/{patientId}")
				public ResponseEntity<Object> updateSoldier(@PathVariable Long patientId, @Validated @RequestBody PatientDto patientDto) {
				    // Retrieve the existing student from the repository
				    Patient patient = repo.findById(patientId).orElse(null);
				    if (patient == null) {
				        return new ResponseEntity<>("Patient with ID " + patientId + " not found", HttpStatus.NOT_FOUND);
				    }
				    patient.setFirstName(patientDto.getFirstName());
					patient.setLastName(patientDto.getLastName());
					patient.setDob(patientDto.getDob());
					patient.setContactInfo(patientDto.getContactInfo());
				    repo.save(patient);
				    return ResponseEntity.ok(patient);
				}
				
				//DELETING Patient INFO
				
				@DeleteMapping("/{patientId}")
				public ResponseEntity<Object> deleteSoldier (@PathVariable Long patientId){
					Patient patient = repo.findById(patientId).orElse(null);
				    if (patient == null) {
				        return new ResponseEntity<>("Patient with ID " + patientId + " not found", HttpStatus.NOT_FOUND);
				    }
				    
				    repo.delete(patient);
				    return ResponseEntity.status(HttpStatus.OK).body("Patient with id " + patientId + " deleted successfully");
					
				}
}
