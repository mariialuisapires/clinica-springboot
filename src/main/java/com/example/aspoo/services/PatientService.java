package com.example.aspoo.services;


import com.example.aspoo.repository.PatientRepository;

import com.example.aspoo.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> listAllPatients(){
        return this.patientRepository.findAll();
    }

    public Patient listById (int id) {
        return this.patientRepository.findById(id).orElseThrow();
    }

    public Patient createPatient (Patient patientRequest){
        return this.patientRepository.save(patientRequest);
    }

    public void updatePatient(int id_patient, Patient patientRequest){
        Patient patient = this.patientRepository.getReferenceById(id_patient);
        patient.setName(patientRequest.getName());
        patient.setCpf(patientRequest.getCpf());
        patient.setCellphone(patientRequest.getCellphone());
        patient.setEmail(patientRequest.getEmail());
        patient.setAddress(patientRequest.getAddress());


        this.patientRepository.save(patient);
    }


    public void deletePatient (int id_patient){
        Patient patient = this.patientRepository.getReferenceById(id_patient);
        this.patientRepository.delete(patient);
    }
}
