package com.example.aspoo.dto;

public class ConsultationDTO {
    private int id_consultation;
    private Double finalPrice;
    private int id_doctor;
    private int id_patient;
    private int id_remedy;



    public ConsultationDTO() {}


    public ConsultationDTO(int id_consultation, int id_doctor, int id_patient, int id_remedy, Double finalPrice) {
        this.id_consultation = id_consultation;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_remedy = id_remedy;
        this.finalPrice = finalPrice;
    }

    // Getters e setters
    public int getId_consultation() { return id_consultation; }
    public void setId_consultation(Integer id_consultation) { this.id_consultation = id_consultation; }

    public int getId_doctor() { return id_doctor; }
    public void setId_doctor(int id_doctor) { this.id_doctor = id_doctor; }

    public int getId_patient() { return id_patient; }
    public void setId_patient(int id_patient) { this.id_patient = id_patient; }

    public int getId_remedy() { return id_remedy; }
    public void setId_remedy(Integer id_remedy) { this.id_remedy = id_remedy; }

    public Double getFinalPrice() {return finalPrice; }
    public void setFinalPrice(Double finalPrice) { this.finalPrice = finalPrice; }
}
