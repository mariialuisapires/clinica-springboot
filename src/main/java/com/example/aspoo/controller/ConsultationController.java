package com.example.aspoo.controller;



import com.example.aspoo.dto.ConsultationDTO;
import com.example.aspoo.model.Consultation;
import com.example.aspoo.model.Remedy;
import com.example.aspoo.services.ConsultationService;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/consultation")

public class ConsultationController {

    private ConsultationService consultationService;
    private ConsultationController ConsultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> listAllConsultation() {
        return ResponseEntity
                .ok()
                .body(this.consultationService.listAllConsultation());
    }



    @PostMapping
    public ResponseEntity<Consultation> createConsultation(@RequestBody Consultation consultationRequest) {
        Consultation patient = this.consultationService.createConsultation(consultationRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_consultation}")
                .buildAndExpand(patient.getId_consultation()).toUri();

        return ResponseEntity
                .created(uri)
                .body(patient);
    }

    @PutMapping("/{id_consultation}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable int id_consultation, @RequestBody Consultation consultationUpdated) {
        this.consultationService.updateConsultation(id_consultation, consultationUpdated);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_consultation}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable int id_consultation) {
        this.consultationService.deleteConsultation(id_consultation);
        return  ResponseEntity
                .ok()
                .build();
    }
}
