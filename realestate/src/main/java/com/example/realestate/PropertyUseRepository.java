package com.example.realestate;



import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyUseRepository extends JpaRepository<PropertyUse,Integer> {


}




