package com.financeiro.controlefinanceiro.service;

import com.financeiro.controlefinanceiro.model.Transacao;
import com.financeiro.controlefinanceiro.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public Transacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Transação não encontrada: " + id));
    }

    public Transacao cadastrar(Transacao transacao) {
        return repository.save(transacao);
    }

    public Transacao atualizar(Long id, Transacao dados) {
        Transacao transacao = buscarPorId(id);

        transacao.setDescricao(dados.getDescricao());
        transacao.setValor(dados.getValor());
        transacao.setTipo(dados.getTipo());

        return repository.save(transacao);
    }

    public void excluir(Long id) {
        Transacao transacao = buscarPorId(id);
        repository.delete(transacao);
    }

    public double calcularSaldo() {
        double saldo = 2300.00;

        for (Transacao transacao : repository.findAll()) {

            if ("DESPESA".equalsIgnoreCase(transacao.getTipo())) {
                saldo -= transacao.getValor();

            } else if ("RECEITA".equalsIgnoreCase(transacao.getTipo())) {
                saldo += transacao.getValor();
            }
        }

        return saldo;
    }
}
