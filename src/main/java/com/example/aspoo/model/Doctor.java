package com.example.aspoo.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor", nullable = false, unique = true)
    private Integer id_doctor;
    private String name;
    private String cpf;
    private String cellphone;
    private String email;
    private String specialty ;
    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultations;

    public Doctor() {}

    public Doctor(Integer id_doctor, String name, String cpf, String cellphone, String email, String address)
    {
        this.id_doctor = id_doctor;
        this.name = name;
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.email = email;
        this.specialty  = specialty ;
    }

    public Integer getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Integer id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty () {
        return specialty ;
    }

    public void setSpecialty (String specialty ) {
        this.specialty  = specialty ;
    }


    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setSale(List<Consultation> sales) {
        this.consultations = consultations;
    }
}
