package com.example.projetoRHtech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoRHtech.model.FuncionarioModel;
import com.example.projetoRHtech.repository.FuncionarioRepository;

@Service
public class FuncionarioService {


     @Autowired // injeta o repositório no serviço
    private FuncionarioRepository repository;  //encapsulando uma variavel

    public List<FuncionarioModel> listar() {
        return repository.findAll(); //findAll busca todos alunos 
    }

    // salva os alunos
    public FuncionarioModel salvar(FuncionarioModel funcionarios) {
        return repository.save(funcionarios); //save salva
    }

    // busca aluno por id
    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return repository.findById(id); //findById busca aluno por id
    }

    // atualizar os dados de um cargo por ID
    public Optional<FuncionarioModel> atualizar(Long id, FuncionarioModel novoFuncionarios) {
    return repository.findById(id).map(funcionario -> {
        funcionario.setNome(novoFuncionarios.getNome());
        funcionario.setEmail(novoFuncionarios.getEmail());
        funcionario.setSenha(novoFuncionarios.getSenha());
        funcionario.setCep(novoFuncionarios.getCep());
        funcionario.setEndereco(novoFuncionarios.getEndereco());
        funcionario.setNumero(novoFuncionarios.getNumero());
        funcionario.setBairro(novoFuncionarios.getBairro());
        funcionario.setCidade(novoFuncionarios.getCidade());
        funcionario.setEstado(novoFuncionarios.getEstado());
        return repository.save(funcionario);
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

    
