package br.org.senai.conveniospagamento.strategies;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.exceptions.RegraDeNegocioException;
import br.org.senai.conveniospagamento.services.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SusPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private SusService susService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.SUS;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getCpf() == null || paciente.getNumeroPis() == null) {
            throw new RegraDeNegocioException("Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
        }

        susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
    }
}
