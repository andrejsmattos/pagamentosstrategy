package br.org.senai.conveniospagamento.strategies;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.services.BacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PixPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private BacenService bacenService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.PIX;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(informacoesPagamento.getIdTransacaoPix() != null) {
            bacenService.processaPix(informacoesPagamento.getIdTransacaoPix(), valor);
        }
        else {
            bacenService.geraChavePixParaPagamento(paciente.getChavePix(), valor);
        }
    }
}
