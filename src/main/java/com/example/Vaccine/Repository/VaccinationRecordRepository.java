package com.example.Vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vaccine.entity.VaccinationRecord;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long>{

}
