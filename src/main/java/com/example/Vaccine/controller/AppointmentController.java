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
import com.example.Vaccine.Repository.AppointmentRepository;
import com.example.Vaccine.Repository.PatientRepository;
import com.example.Vaccine.Repository.VaccineRepository;
import com.example.Vaccine.entity.Appointment;
import com.example.Vaccine.entity.Patient;
import com.example.Vaccine.entity.Vaccine;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

	
	 @Autowired
	 private AppointmentRepository repo;

	 @Autowired
	 private PatientRepository patientRepository;
	 
	 @Autowired
	 private VaccineRepository vaccineRepository;
	 
	//Display all Appointments
			@GetMapping("/all")
			public List<Appointment> getAllAppointment(){
				return repo.findAll();
			}
			
			// Get Appointment by ID
		    @GetMapping("/{appointmentId}")
		    public ResponseEntity<Object> getAppointment(@PathVariable Long appointmentId) {
		        Appointment appointment = repo.findById(appointmentId).orElse(null);
		        if (appointment == null) {
		            return new ResponseEntity<>("Appointment with ID " + appointmentId + " not found", HttpStatus.NOT_FOUND);
		        } else {
		            return ResponseEntity.ok(appointment);
		        }
		    }
		    
		 // Create a new Appointment
		    @PostMapping("/addAppointment")
		    public ResponseEntity<Object> saveAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
		    	Appointment appointment = new Appointment();
		    	appointment.setAppointmentDate(appointmentDto.getAppointmentDate());

		        Vaccine vaccine = vaccineRepository.findById(appointmentDto.getVaccine())
		                .orElseThrow(() -> new RuntimeException("Vacine not found"));
		        appointment.setVaccine(vaccine);
		        
		        Patient patient = patientRepository.findById(appointmentDto.getPatient())
		                .orElseThrow(() -> new RuntimeException("Patient not found"));
		        appointment.setPatient(patient);
		        appointment.setStatus(appointmentDto.getStatus());

		        repo.save(appointment);

		        return ResponseEntity.ok(appointment);
		    }
		    
		 // Update an existing Appointment
		    @PutMapping("/updateAppointment/{appointmentId}")
		    public ResponseEntity<Object> updateAppointment(@PathVariable Long appointmentId, @Valid @RequestBody AppointmentDto appointmentDto) {
		        Appointment existingAppointment = repo.findById(appointmentId)
		                .orElseThrow(() -> new RuntimeException("Appointment not found"));

		        existingAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());

		        Vaccine vaccine = vaccineRepository.findById(appointmentDto.getVaccine())
		                .orElseThrow(() -> new RuntimeException("Vacine not found"));
		        existingAppointment.setVaccine(vaccine);
		        
		        Patient patient = patientRepository.findById(appointmentDto.getPatient())
		                .orElseThrow(() -> new RuntimeException("Patient not found"));
		        existingAppointment.setPatient(patient);
		        existingAppointment.setStatus(appointmentDto.getStatus());

		        repo.save(existingAppointment);

		        return ResponseEntity.ok(existingAppointment);
		    }
		    
		 // Delete an existing Appointment
		    @DeleteMapping("/deleteAppointment/{appointmentId}")
		    public ResponseEntity<Object> deleteAppointment(@PathVariable Long appointmentId) {
		    	Appointment existingAppointment = repo.findById(appointmentId)
		                .orElseThrow(() -> new RuntimeException("Appointment not found"));

		        repo.delete(existingAppointment);

		        return ResponseEntity.ok("Appointment with ID " + appointmentId + " has been deleted");
		    }
}
