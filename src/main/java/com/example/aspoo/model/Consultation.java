package com.example.aspoo.model;

import jakarta.persistence.*;

import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "Consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation", nullable = false, unique = true)
    private Integer id_consultation;

    @OneToOne
    @JoinColumn(name = "id_remedy", referencedColumnName = "id_remedy")
    private Remedy remedy;

    @OneToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")
    private Doctor doctor;

    private Double finalPrice;

    public Consultation() {
    }

    // Construtor com todos os campos (menos id_venda, que é auto-gerado)
    public Consultation(Remedy remedy,Doctor doctor, Patient patient, double finalPrice) {
        this.remedy = remedy;
        this.doctor = doctor;
        this.patient = patient;
        this.finalPrice = finalPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    // Getters e setters
    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(Integer id_consultation) {
        this.id_consultation = id_consultation;
    }

    public Remedy getRemedy() {
        return remedy;
    }

    public void setRemedy(Remedy remedy) {
        this.remedy = remedy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
