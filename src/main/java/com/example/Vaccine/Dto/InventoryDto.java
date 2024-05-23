package com.example.Vaccine.Dto;

import com.example.Vaccine.entity.Vaccine;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class InventoryDto {
	    private Long vaccine;
	    private String location;
	    private int quantityAvailable;
	    private String lastRestockDate;
		public Long getVaccine() {
			return vaccine;
		}
		public void setVaccine(Long vaccine) {
			this.vaccine = vaccine;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getQuantityAvailable() {
			return quantityAvailable;
		}
		public void setQuantityAvailable(int quantityAvailable) {
			this.quantityAvailable = quantityAvailable;
		}
		public String getLastRestockDate() {
			return lastRestockDate;
		}
		public void setLastRestockDate(String lastRestockDate) {
			this.lastRestockDate = lastRestockDate;
		}
		

	    
}
