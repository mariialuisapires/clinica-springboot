package com.example.aspoo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Remedies")
public class Remedy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedy", nullable = false)
    private Integer id_remedy;
    private String type;
    private double price;

    @OneToMany(mappedBy = "remedy")
    @JsonManagedReference(value = "remedy-consultations")
    private List<Consultation> consultations = new ArrayList<>();




    public Remedy() {}

    public Remedy(int id, String type, double price) {
        this.id_remedy = id;
        this.type = type;
        this.price = price;


    }

    public Integer getId_remedy() {
        return id_remedy;
    }

    public void setId_remedy(Integer id_remedy) {
        this.id_remedy = id_remedy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
