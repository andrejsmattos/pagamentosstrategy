package br.org.senai.conveniospagamento.factories;

import br.org.senai.conveniospagamento.strategies.PagamentoStrategy;
import br.org.senai.conveniospagamento.entities.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoStrategyFactory {

    @Autowired
    private List<PagamentoStrategy> strategies;

    public PagamentoStrategy getStrategyParaPagamento(FormaPagamento formapagamento){
        for (PagamentoStrategy strategy: strategies) {
            if (strategy.tipoDePagamento().equals(formapagamento)){
                return strategy;
            }
        }
        return null;
    }
}
