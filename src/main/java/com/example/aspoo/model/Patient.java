package com.example.aspoo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_patient;
    private String name;
    private String cpf;
    private String cellphone;
    private String email;
    private String address;

    public Patient() {}

    public Patient(Integer id_patient, String name, String cpf, String cellphone, String email, String address)
    {
        this.id_patient = id_patient;
        this.name = name;
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.email = email;
        this.address = address;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
