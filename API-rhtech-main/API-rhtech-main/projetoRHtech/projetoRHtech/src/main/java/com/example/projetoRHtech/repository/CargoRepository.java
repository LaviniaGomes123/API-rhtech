package com.example.projetoRHtech.repository;


import com.example.projetoRHtech.model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Long> {
} 