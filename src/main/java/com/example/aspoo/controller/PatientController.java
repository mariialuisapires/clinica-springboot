package com.example.aspoo.controller;


import com.example.aspoo.model.Patient;
import com.example.aspoo.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> listAllPatients() {
        return ResponseEntity
                .ok()
                .body(this.patientService.listAllPatients());
    }

    @GetMapping("/{id_patient}")
    public ResponseEntity<Patient> listById(@PathVariable int id_patient) {
        return ResponseEntity
                .ok(this.patientService.listById(id_patient));
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patientRequest) {
        Patient patient = this.patientService.createPatient(patientRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_patient}")
                .buildAndExpand(patient.getId_patient()).toUri();

        return ResponseEntity
                .created(uri)
                .body(patient);
    }

    @PutMapping("/{id_patient}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id_patient, @RequestBody Patient patientUpdated) {
        this.patientService.updatePatient(id_patient, patientUpdated);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_patient}")
    public ResponseEntity<Void> deletePatient(@PathVariable int id_patient) {
        this.patientService.deletePatient(id_patient);
        return ResponseEntity
                .ok()
                .build();
    }
}
