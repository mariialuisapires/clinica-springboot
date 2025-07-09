package com.example.aspoo.repository;


import com.example.aspoo.model.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RemedyRepository extends JpaRepository<Remedy, Integer> {
}


