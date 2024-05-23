package com.example.Vaccine.Dto;

import com.example.Vaccine.entity.Patient;
import com.example.Vaccine.entity.Vaccine;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class VaccinationRecordDto {
    private Long patient;
    private Long vaccine;
    private int doseNumber;
    private String vaccinationDate;
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
	public int getDoseNumber() {
		return doseNumber;
	}
	public void setDoseNumber(int doseNumber) {
		this.doseNumber = doseNumber;
	}
	public String getVaccinationDate() {
		return vaccinationDate;
	}
	public void setVaccinationDate(String vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	
    
}
