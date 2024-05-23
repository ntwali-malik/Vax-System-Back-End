package com.example.Vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vaccine.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
