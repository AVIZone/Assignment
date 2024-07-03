package com.xcelore.Assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xcelore.Assignment.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findBySpecialityAndCity(String speciality, String city);
	
	void deleteById(Long id);
}