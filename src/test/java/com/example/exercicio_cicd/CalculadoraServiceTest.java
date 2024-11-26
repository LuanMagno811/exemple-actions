package com.example.exercicio_cicd;

import com.example.exercicio_cicd.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;

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

    @Test
    @DisplayName("Quando acionado com 19 e 9, então deve lançar uma exceção")
    public void testDividirPorZero() {

        //Arrange
        CalculadoraService calculadoraService = new CalculadoraService(); 
        double a = 10;
        double b = 0;
        var expectedMessage = "400 BAD_REQUEST \"Não é possível dividir por zero\"";

        //Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            //Act
            calculadoraService.dividir(a, b);
        });

        //Assert
        assertEquals(expectedMessage, exception.getMessage());
    }
}