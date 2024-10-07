package br.org.senai.conveniospagamento.services;

import br.org.senai.conveniospagamento.strategies.PagamentoStrategy;
import br.org.senai.conveniospagamento.factories.PagamentoStrategyFactory;
import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.exceptions.RegraDeNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoStrategyFactory pagamentoStrategyFactory;


    public void processaPagamento(PessoaPaciente paciente,
                                  FormaPagamento formaPagamento,
                                  InformacoesPagamento informacoesPagamento,
                                  Float valor) {

        PagamentoStrategy pagamentoStrategy = pagamentoStrategyFactory.getStrategyParaPagamento(formaPagamento);
        pagamentoStrategy.processaPagamento(paciente, informacoesPagamento, valor);
    }

}