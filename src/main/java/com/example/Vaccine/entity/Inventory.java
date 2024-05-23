package com.example.Vaccine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryID")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "VaccineID", nullable = false)
    private Vaccine vaccine;

    @Column(name = "Location", nullable = false)
    private String location;

    @Column(name = "QuantityAvailable", nullable = false)
    private int quantityAvailable;

    @Column(name = "LastRestockDate", nullable = false)
    private String lastRestockDate;

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
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
