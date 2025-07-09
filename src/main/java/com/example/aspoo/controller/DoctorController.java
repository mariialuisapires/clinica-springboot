package com.example.aspoo.controller;

import com.example.aspoo.model.Doctor;
import com.example.aspoo.repository.DoctorRepository;
import com.example.aspoo.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.Doc;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        return ResponseEntity
                .ok()
                .body(this.doctorService.listAllDoctors());
    }

    @GetMapping("/{id_doctor}")
    public ResponseEntity<Doctor> listById (@PathVariable int id_doctor) {
        return ResponseEntity
                .ok(this.doctorService.listById(id_doctor));
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctorRequest) {
        Doctor pacient = this.doctorService.createDoctor(doctorRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_doctor}")
                .buildAndExpand(pacient.getId_doctor()).toUri();

        return ResponseEntity
                .created(uri)
                .body(pacient);
    }
    @PutMapping("/{id_doctor}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id_doctor, @RequestBody Doctor doctorUpdated) {
        this.doctorService.updateDoctor(id_doctor, doctorUpdated);
        return ResponseEntity
                .ok()
                .build();
    }

    @DeleteMapping("/{id_doctor}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int id_doctor) {
        this.doctorService.deleteDoctor(id_doctor);
        return  ResponseEntity
                .ok()
                .build();
    }
}
