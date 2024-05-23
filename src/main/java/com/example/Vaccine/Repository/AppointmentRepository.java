package com.example.Vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vaccine.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
