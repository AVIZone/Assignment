package com.xcelore.Assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^(Delhi|Noida|Faridabad)$", message = "City must be Delhi, Noida, or Faridabad")
    @Size(max = 20, message = "City must not exceed 20 characters")
    @Column(name = "city")
    private String city;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    @Column(name = "phone_number") // Use an underscore to avoid case-sensitivity issues
    private String phoneNumber;

    @Pattern(regexp = "^(Orthopaedic|Gynecology|Dermatology|ENT)$", message = "Speciality must be Orthopaedic, Gynecology, Dermatology, or ENT")
    @Column(name = "speciality")
    private String speciality;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", speciality=" + speciality + "]";
	}
    
}
