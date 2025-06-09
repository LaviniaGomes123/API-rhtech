package com.example.projetoRHtech.projetoRHtech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name= "funcionarios")
@Getter
@Setter
@NoArgsConstructor

public class CargoModel{
    @id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;


    @Column (nullable = false)
    private String email;

    @Column (nullable)
    private String senha;
}
