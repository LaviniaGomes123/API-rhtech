package com.example.projetoRHtech.controller;
import com.example.projetoRHtech.model.FuncionarioModel;
import com.example.projetoRHtech.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/funcionarios")

public class FuncionarioController {

      @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioModel> listar() {
        return service.listar();
    }

    @PostMapping
    public FuncionarioModel cadastrar(@RequestBody FuncionarioModel funcionarios) {
        return service.salvar(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build(); // 204 - No Content
        } else {
            return ResponseEntity.notFound().build();  
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionariosAtualizado) {
        return service.atualizar(id, funcionariosAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

   