package com.example.exercicio_cicd;

import com.example.exercicio_cicd.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraServiceTest {
    private final CalculadoraService calculadoraService = new CalculadoraService();
    @Test
    void dividirComDenominadorNaoZero() {
        double result = calculadoraService.dividir(10, 2);
        assertEquals(5, result);
    }
    @Test
    void dividirComDenominadorZeroLancaExcecao() {
        assertThrows(ResponseStatusException.class, () -> calculadoraService.dividir(10, 0));
    }
    @Test
    void dividirComNumerosNegativos() {
        double result = calculadoraService.dividir(-10, -2);
        assertEquals(5, result);
    }
    @Test
    void dividirComNumerosPositivoENegativo() {
        double result = calculadoraService.dividir(10, -2);
        assertEquals(-5, result);
    }
    @Test
    void dividirComNumeradorZero() {
        double result = calculadoraService.dividir(0, 2);
        assertEquals(0, result);
    }
}