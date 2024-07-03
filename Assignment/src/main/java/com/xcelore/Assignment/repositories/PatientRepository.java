package com.xcelore.Assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xcelore.Assignment.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	void deleteById(Long id);
}
