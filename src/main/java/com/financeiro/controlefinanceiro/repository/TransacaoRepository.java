package com.financeiro.controlefinanceiro.repository;

import com.financeiro.controlefinanceiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}