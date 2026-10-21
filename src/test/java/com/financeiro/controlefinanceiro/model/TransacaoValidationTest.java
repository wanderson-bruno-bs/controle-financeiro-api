package com.financeiro.controlefinanceiro.model;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoValidationTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    static void configurar() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    static void finalizar() {
        factory.close();
    }

    @Test
    void deveAceitarTransacaoValida() {
        Transacao transacao = new Transacao(
                "Supermercado", 150.00, "DESPESA"
        );

        var erros = validator.validate(transacao);

        assertTrue(erros.isEmpty());
    }

    @Test
    void deveRejeitarValorNegativo() {
        Transacao transacao = new Transacao(
                "Supermercado", -50.00, "DESPESA"
        );

        var erros = validator.validate(transacao);

        assertFalse(erros.isEmpty());
    }

    @Test
    void deveRejeitarTipoInvalido() {
        Transacao transacao = new Transacao(
                "Supermercado", 150.00, "COMPRA"
        );

        var erros = validator.validate(transacao);

        assertFalse(erros.isEmpty());
    }

    @Test
    void deveRejeitarDescricaoVazia() {
        Transacao transacao = new Transacao(
                "", 150.00, "DESPESA"
        );

        var erros = validator.validate(transacao);

        assertFalse(erros.isEmpty());
    }
}
