package com.example.aspoo.services;

import com.example.aspoo.model.Remedy;
import com.example.aspoo.repository.RemedyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedyService {
    private RemedyRepository remedyRepository;

    public RemedyService(RemedyRepository remedyRepository) {
        this.remedyRepository = remedyRepository;
    }

    public List<Remedy> listAllRemedy() {
        return this.remedyRepository.findAll();
    }

    public Remedy listById(int id_remedy) {
        return this.remedyRepository.findById(id_remedy).orElseThrow();
    }

    public Remedy createRemedy(Remedy remedyRequest) {
        return this.remedyRepository.save(remedyRequest);
    }

    public void updateRemedy(int id_remedy, Remedy remedyRequest) {
        Remedy remedy = this.remedyRepository.getReferenceById(id_remedy);

        remedy.setPrice(remedyRequest.getPrice());
        remedy.setType(remedyRequest.getType());


        this.remedyRepository.save(remedy);
    }


    public void deleteRemedy(int id_remedy) {
        Remedy remedy = this.remedyRepository.getReferenceById(id_remedy);
        this.remedyRepository.delete(remedy);
    }

}