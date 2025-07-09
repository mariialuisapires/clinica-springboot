package com.example.aspoo.services;

import com.example.aspoo.model.Consultation;
import com.example.aspoo.model.Doctor;
import com.example.aspoo.model.Patient;
import com.example.aspoo.model.Remedy;
import com.example.aspoo.dto.ConsultationDTO;
import com.example.aspoo.repository.ConsultationRepository;
import com.example.aspoo.repository.DoctorRepository;
import com.example.aspoo.repository.PatientRepository;
import com.example.aspoo.repository.RemedyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service

public class ConsultationService {

    @Autowired
    private RemedyRepository remedyRepository; //  Isso é o que tem getReferenceById()

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public List<Consultation> listAllConsultation(){
        return this.consultationRepository.findAll();
    }

    public Consultation listById (int id_consultation) {
        return this.consultationRepository.findById(id_consultation).orElseThrow();
    }

    public Consultation createConsultation (Consultation consultationRequest){
        return this.consultationRepository.save(consultationRequest);
    }

    public void updateConsultation(int id_consultation, Consultation consultationRequest) {
        Consultation consultation = this.consultationRepository.getReferenceById(id_consultation);

        if (consultationRequest.getRemedy() != null && consultationRequest.getRemedy().getId_remedy() != null) {
            Remedy remedy = remedyRepository.getReferenceById(consultationRequest.getRemedy().getId_remedy());
            consultation.setRemedy(remedy);
        }

        if (consultationRequest.getPatient() != null && consultationRequest.getPatient().getId_patient() != null) {
            Patient patient = patientRepository.getReferenceById(consultationRequest.getPatient().getId_patient());
            consultation.setPatient(patient);
        }

        if (consultationRequest.getDoctor() != null && consultationRequest.getDoctor().getId_doctor() != null) {
            Doctor doctor = doctorRepository.getReferenceById(consultationRequest.getDoctor().getId_doctor());
            consultation.setDoctor(doctor);
        }

        if (consultationRequest.getFinalPrice() != null) {
            consultation.setFinalPrice(consultationRequest.getFinalPrice());
        }

        this.consultationRepository.save(consultation);
    }


    public void deleteConsultation (int id_consultation_patient){
        Consultation patient = this.consultationRepository.getReferenceById(id_consultation_patient);
        this.consultationRepository.delete(patient);
    }

    public ConsultationDTO toDTO(Consultation consultation) {
        return new ConsultationDTO(
                consultation.getId_consultation(),
                consultation.getDoctor() != null ? consultation.getDoctor().getId_doctor() : null,
                consultation.getPatient() != null ? consultation.getPatient().getId_patient() : null,
                consultation.getRemedy() != null ? consultation.getRemedy().getId_remedy() : null,
                consultation.getFinalPrice() != null ? consultation.getFinalPrice() : 0.0
        );
    }
}
