package com.example.Vaccine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "VaccinationRecords")
public class VaccinationRecord {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "RecordID")
	    private Long recordId;

	    @ManyToOne
	    @JoinColumn(name = "PatientID", nullable = false)
	    private Patient patient;

	    @ManyToOne
	    @JoinColumn(name = "VaccineID", nullable = false)
	    private Vaccine vaccine;

	    @Column(name = "DoseNumber", nullable = false)
	    private int doseNumber;

	    @Column(name = "VaccinationDate", nullable = false)
	    private String vaccinationDate;

		public Long getRecordId() {
			return recordId;
		}

		public void setRecordId(Long recordId) {
			this.recordId = recordId;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Vaccine getVaccine() {
			return vaccine;
		}

		public void setVaccine(Vaccine vaccine) {
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
