package com.xcelore.Assignment.controller;

import org.springframework.web.bind.annotation.*;
import com.xcelore.Assignment.entity.Doctor;
import com.xcelore.Assignment.entity.Patient;
import com.xcelore.Assignment.services.DoctorService;
import com.xcelore.Assignment.services.PatientService;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
    @PostMapping
    public ResponseEntity<Object> addPatient(@RequestBody Patient patient) {
        // Save the patient using the patientService
        patientService.addPatient(patient);

        // Return a success message
        return ResponseEntity.ok(patient);
    }
	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
    
    private final PatientService patientService;
    private final DoctorService doctorService;
    
    // Define the hashmap categorizing symptoms under specialties
    private final Map<String, List<String>> specialtySymptomsMap = new HashMap<>();

    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;

        // Initialize the hashmap with medical specialties and associated symptoms
        initializeSpecialtySymptomsMap();
    }

    // Endpoint to suggest specialty and return doctors in the same city
    @GetMapping("/{id}/suggest-doctors")
    public ResponseEntity<Object> suggestSpecialtyAndDoctors(@PathVariable Long id) {
        Optional<Patient> patientOpt = patientService.findPatientById(id);

        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            String symptom = patient.getSymptom();

            // Find the medical specialty key for the patient's symptom
            String specialtyKey = findSpecialtyForKey(symptom);

            if (specialtyKey != null) {
                // Retrieve doctors in the same city for the found specialty
                List<Doctor> suggestedDoctors = doctorService.findDoctorsBySpecialtyAndCity(specialtyKey,
                        patient.getCity());

                // Return the doctors in the same city
                return ResponseEntity.ok(suggestedDoctors);
            } else {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found with ID: " + id);
        }
    }

    // Initialize the hashmap with medical specialties and associated symptoms
    private void initializeSpecialtySymptomsMap() {
        specialtySymptomsMap.put("Orthopaedic", Arrays.asList("Arthritis", "Back Pain", "Tissue injuries"));
        specialtySymptomsMap.put("Gynecology", Collections.singletonList("Dysmenorrhea"));
        specialtySymptomsMap.put("Dermatology", Arrays.asList("Skin infection", "Skin burn"));
        specialtySymptomsMap.put("ENT", Collections.singletonList("Ear pain"));
    }

    // Helper method to find the specialty key for a given symptom
    private String findSpecialtyForKey(String symptom) {
        for (Map.Entry<String, List<String>> entry : specialtySymptomsMap.entrySet()) {
            if (entry.getValue().contains(symptom)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
