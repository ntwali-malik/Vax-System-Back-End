package com.example.Vaccine.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Vaccines")
public class Vaccine {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "VaccineID")
	    private Long vaccineId;

	    @Column(name = "VaccineName", nullable = false)
	    private String vaccineName;

	    @Column(name = "Manufacturer", nullable = false)
	    private String manufacturer;

	    @Column(name = "BatchNumber", nullable = false)
	    private String batchNumber;

	    @Column(name = "ExpiryDate", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private String expiryDate;

		public Long getVaccineId() {
			return vaccineId;
		}

		public void setVaccineId(Long vaccineId) {
			this.vaccineId = vaccineId;
		}

		public String getVaccineName() {
			return vaccineName;
		}

		public void setVaccineName(String vaccineName) {
			this.vaccineName = vaccineName;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getBatchNumber() {
			return batchNumber;
		}

		public void setBatchNumber(String batchNumber) {
			this.batchNumber = batchNumber;
		}

		public String getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
	    
	    
}
