package com.xcelore.Assignment.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(name = "name")
    private String name;

    @Size(max = 20, message = "City must not exceed 20 characters")
    @Column(name = "city")
    private String city;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit number")
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Pattern(regexp = "^(Arthritis|Back Pain|Tissue injuries|Dysmenorrhea|Skin infection|skin burn|Ear pain)$", message = "Invalid symptom")
    @Column(name = "symptom")
    private String symptom;


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

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
