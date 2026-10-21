package com.financeiro.controlefinanceiro.controller;

import com.financeiro.controlefinanceiro.model.Transacao;
import com.financeiro.controlefinanceiro.service.TransacaoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacoes")
@CrossOrigin(origins = "http://localhost:5173")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transacao> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Transacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transacao cadastrar(@Valid @RequestBody Transacao transacao) {
        return service.cadastrar(transacao);
    }

    @PutMapping("/{id}")
    public Transacao atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Transacao transacao) {

        return service.atualizar(id, transacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/saldo")
    public Map<String, Double> consultarSaldo() {
        return Map.of("saldo", service.calcularSaldo());
    }


}
