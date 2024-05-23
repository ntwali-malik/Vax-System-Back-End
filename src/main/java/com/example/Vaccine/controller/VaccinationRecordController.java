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

import com.example.Vaccine.Dto.AppointmentDto;
import com.example.Vaccine.Dto.VaccinationRecordDto;
import com.example.Vaccine.Repository.PatientRepository;
import com.example.Vaccine.Repository.VaccinationRecordRepository;
import com.example.Vaccine.Repository.VaccineRepository;
import com.example.Vaccine.entity.Appointment;
import com.example.Vaccine.entity.Patient;
import com.example.Vaccine.entity.VaccinationRecord;
import com.example.Vaccine.entity.Vaccine;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/VaccinationRecord")
@CrossOrigin(origins = "http://localhost:3000")
public class VaccinationRecordController {

	@Autowired
	private VaccinationRecordRepository repo;
	
	 @Autowired
	 private PatientRepository patientRepository;
	 
	 @Autowired
	 private VaccineRepository vaccineRepository;
	 
	//Display all Vaccination Record
		@GetMapping("/all")
		public List<VaccinationRecord> getAllVaccinationRecords(){
			return repo.findAll();
		}
		
		// Get Record by ID
	    @GetMapping("/{recordId}")
	    public ResponseEntity<Object> getVaccinationRecords(@PathVariable Long recordId) {
	    	VaccinationRecord vaccinationRecord = repo.findById(recordId).orElse(null);
	        if (vaccinationRecord == null) {
	            return new ResponseEntity<>("Vaccination Record with ID " + recordId + " not found", HttpStatus.NOT_FOUND);
	        } else {
	            return ResponseEntity.ok(vaccinationRecord);
	        }
	    }
	    
	    // Create a new Record
	    @PostMapping("/addVaccinationRecord")
	    public ResponseEntity<Object> saveAppointment(@Valid @RequestBody VaccinationRecordDto vaccinationRecordDto) {
	    	VaccinationRecord vaccinationRecord = new VaccinationRecord();
	    	vaccinationRecord.setDoseNumber(vaccinationRecordDto.getDoseNumber());

	        Vaccine vaccine = vaccineRepository.findById(vaccinationRecordDto.getVaccine())
	                .orElseThrow(() -> new RuntimeException("Vacine not found"));
	        vaccinationRecord.setVaccine(vaccine);
	        
	        Patient patient = patientRepository.findById(vaccinationRecordDto.getPatient())
	                .orElseThrow(() -> new RuntimeException("Patient not found"));
	        vaccinationRecord.setPatient(patient);
	        vaccinationRecord.setVaccinationDate(vaccinationRecordDto.getVaccinationDate());

	        repo.save(vaccinationRecord);

	        return ResponseEntity.ok(vaccinationRecord);
	    }
	    
	 // Update an existing Vaccination Record
	    @PutMapping("/updateVaccinationRecord/{recordId}")
	    public ResponseEntity<Object> updateAppointment(@PathVariable Long recordId, @Valid @RequestBody VaccinationRecordDto vaccinationRecordDto) {
	    	VaccinationRecord existingVaccinationRecord = repo.findById(recordId)
	                .orElseThrow(() -> new RuntimeException("Vaccination Record not found"));

	    	existingVaccinationRecord.setDoseNumber(vaccinationRecordDto.getDoseNumber());

	        Vaccine vaccine = vaccineRepository.findById(vaccinationRecordDto.getVaccine())
	                .orElseThrow(() -> new RuntimeException("Vacine not found"));
	        existingVaccinationRecord.setVaccine(vaccine);
	        
	        Patient patient = patientRepository.findById(vaccinationRecordDto.getPatient())
	                .orElseThrow(() -> new RuntimeException("Patient not found"));
	        existingVaccinationRecord.setPatient(patient);
	        existingVaccinationRecord.setVaccinationDate(vaccinationRecordDto.getVaccinationDate());

	        repo.save(existingVaccinationRecord);

	        return ResponseEntity.ok(existingVaccinationRecord);
	    }
	    
	 // Delete an existing Appointment
	    @DeleteMapping("/deleteVaccinationRecord/{recordId}")
	    public ResponseEntity<Object> deleteAppointment(@PathVariable Long recordId) {
	    	VaccinationRecord existingVaccinationRecord = repo.findById(recordId)
	                .orElseThrow(() -> new RuntimeException("Appointment not found"));

	        repo.delete(existingVaccinationRecord);

	        return ResponseEntity.ok("Vaccination Record with ID " + recordId + " has been deleted");
	    }
}
