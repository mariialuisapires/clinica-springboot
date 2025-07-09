package com.example.aspoo.controller;
import com.example.aspoo.model.Remedy;
import com.example.aspoo.model.Patient;


import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aspoo.services.RemedyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remedy")
public class RemedyController {
    private RemedyService remedyService;

    public RemedyController(RemedyService remedyService) {
        this.remedyService = remedyService;
    }


    @GetMapping("/{id_remedy}")
    public ResponseEntity<Remedy> listById (@PathVariable int id_remedy) {
        return ResponseEntity
                .ok(this.remedyService.listById(id_remedy));
    }
    @GetMapping
    public ResponseEntity<List<Remedy>> listAllRemedy() {
        return ResponseEntity
                .ok()
                .body(this.remedyService.listAllRemedy());
    }
    

    @PostMapping
    public ResponseEntity<Remedy>createRemedy(@RequestBody Remedy remedyRequest) {
        Remedy remedy = this.remedyService.createRemedy(remedyRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_remedy}")
                .buildAndExpand(remedy.getId_remedy()).toUri();

        return ResponseEntity
                .created(uri)
                .body(remedy);
    }
    @PutMapping("/{id_remedy}")
    public ResponseEntity<Remedy> updateRemedy(@PathVariable int id_remedy, @RequestBody Remedy remedyUpdated) {
        this.remedyService.updateRemedy(id_remedy, remedyUpdated);
        return ResponseEntity
                .ok()
                .build();
    }


    @DeleteMapping("/{id_remedy}")
    public ResponseEntity<Void> deleteRemedy(@PathVariable int id_remedy) {
        this.remedyService.deleteRemedy(id_remedy);
        return  ResponseEntity
                .ok()
                .build();
    }
}
