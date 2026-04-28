package com.hcard.patient_risk_monitor.service;

import com.hcard.patient_risk_monitor.entity.Patient;
import com.hcard.patient_risk_monitor.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Get a patient by ID (GET): request body is not required
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }
    // Get all patients (GET): no request body is required
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    // Create a new patient (POST): request body must contain all fields
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    // Fully update a patient (PUT): request body must contain all fields
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        return patientRepository.save(existingPatient);
    }
    // Partially update a patient (PATCH): request body can contain only the fields to be updated
    public Patient patchPatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        if (patient.getName() != null) {
            existingPatient.setName(patient.getName());
        }
        if (patient.getAge() != null) {
            existingPatient.setAge(patient.getAge());
        }
        if (patient.getGender() != null) {
            existingPatient.setGender(patient.getGender());
        }
        return patientRepository.save(existingPatient);
    }
    // Delete a patient (DELETE): request body is not required
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        patientRepository.deleteById(id);
    }
}
