package br.org.senai.conveniospagamento.strategies;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;

public interface PagamentoStrategy {
    FormaPagamento tipoDePagamento();
    void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor);
}
