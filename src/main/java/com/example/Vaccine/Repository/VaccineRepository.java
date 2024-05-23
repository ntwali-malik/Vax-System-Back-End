package com.example.Vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vaccine.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{

}
