package com.example.projetoRHtech.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoRHtech.model.CargoModel;
import com.example.projetoRHtech.repository.CargoRepository;

@Service
public class CargoService {

     @Autowired // injeta o repositório no serviço
    private CargoRepository repository;  //encapsulando uma variavel

    public List<CargoModel> listar() {
        return repository.findAll(); //findAll busca todos alunos 
    }

    // salva os alunos
    public CargoModel salvar(CargoModel cargos) {
        return repository.save(cargos); //save salva
    }

    // busca aluno por id
    public Optional<CargoModel> buscarPorId(Long id) {
        return repository.findById(id); //findById busca aluno por id
    }

    //
    public Optional<CargoModel> atualizar(Long id, CargoModel novoCargo) {
    return repository.findById(id).map(cargo -> {
        cargo.setNome(novoCargo.getNome());
        cargo.setDescricao(novoCargo.getDescricao());
        return repository.save(cargo);
    });
}

    // deleta aluno por id
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id); //deleteById deleta aluno por id
            return true;
        } else {
            return false;
        }
    }
}

    
