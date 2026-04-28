package com.hcard.patient_risk_monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcard.patient_risk_monitor.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
