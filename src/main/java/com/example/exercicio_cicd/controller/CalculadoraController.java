package com.example.exercicio_cicd.controller;

import com.example.exercicio_cicd.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    public final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping("/divisao/{a}/{b} ")
    public ResponseEntity<Double> divisao(@PathVariable double a, @PathVariable double b) {
        return ResponseEntity.ok(calculadoraService.dividir(a, b));
    }
}

