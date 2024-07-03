package com.xcelore.Assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcelore.Assignment.entity.Doctor;
import com.xcelore.Assignment.repositories.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findDoctorsBySpecialtyAndCity(String speciality,String city) {
        return doctorRepository.findBySpecialityAndCity(speciality, city);
    }
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
