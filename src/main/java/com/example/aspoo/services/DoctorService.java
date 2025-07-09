package com.example.aspoo.services;

import com.example.aspoo.model.Doctor;
import com.example.aspoo.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listAllDoctors(){
        return this.doctorRepository.findAll();
    }

    public Doctor listById (int id_doctor) {
        return this.doctorRepository.findById(id_doctor).orElseThrow();
    }

    public Doctor createDoctor (Doctor doctorRequest){
        return this.doctorRepository.save(doctorRequest);
    }

    public void updateDoctor(int id_doctor, Doctor doctorRequest){
        Doctor doctor = this.doctorRepository.getReferenceById(id_doctor);

        doctor.setName(doctorRequest.getName());
        doctor.setCpf(doctorRequest.getCpf());
        doctor.setCellphone(doctorRequest.getCellphone());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setSpecialty (doctorRequest.getSpecialty ());


        this.doctorRepository.save(doctor);
    }


    public void deleteDoctor (int id_doctor){
        Doctor doctor = this.doctorRepository.getReferenceById(id_doctor);
        this.doctorRepository.delete(doctor);
    }
}
