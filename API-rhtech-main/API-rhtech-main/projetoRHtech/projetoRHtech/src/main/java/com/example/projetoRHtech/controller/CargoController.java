package com.example.projetoRHtech.controller;

import com.example.projetoRHtech.model.CargoModel;
import com.example.projetoRHtech.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/cargos")

public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping
    public List<CargoModel> listar() {
        return service.listar();
    }

    @PostMapping
    public CargoModel cadastrar(@RequestBody CargoModel cargo) {
        return service.salvar(cargo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoModel> atualizar(@PathVariable Long id, @RequestBody CargoModel cargoAtualizado) {
        return service.buscarPorId(id)
                .map(cargoExistente -> {
                    cargoExistente.setNome(cargoAtualizado.getNome());
                    cargoExistente.setDescricao(cargoAtualizado.getDescricao());
                    return ResponseEntity.ok(service.salvar(cargoExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build(); // 204 - No Content
        } else {
            return ResponseEntity.notFound().build();   // 404 - Not Found
        }

    }
  }
