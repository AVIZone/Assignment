package com.xcelore.Assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcelore.Assignment.entity.Patient;
import com.xcelore.Assignment.repositories.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}

