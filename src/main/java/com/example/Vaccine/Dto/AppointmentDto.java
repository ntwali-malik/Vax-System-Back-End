package com.example.Vaccine.Dto;

import com.example.Vaccine.entity.Patient;
import com.example.Vaccine.entity.Vaccine;


public class AppointmentDto {
	    private Long patient;
	    private Long vaccine;
	    private String appointmentDate;
	    private String status;
		public Long getPatient() {
			return patient;
		}
		public void setPatient(Long patient) {
			this.patient = patient;
		}
		public Long getVaccine() {
			return vaccine;
		}
		public void setVaccine(Long vaccine) {
			this.vaccine = vaccine;
		}
		public String getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	    
	    
}
