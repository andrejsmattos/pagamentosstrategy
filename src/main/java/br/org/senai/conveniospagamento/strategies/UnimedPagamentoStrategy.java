package br.org.senai.conveniospagamento.strategies;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.exceptions.RegraDeNegocioException;
import br.org.senai.conveniospagamento.services.UnimedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnimedPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private UnimedService unimedService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.CONVENIO_UNIMED;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
            throw new RegraDeNegocioException("Informações obrigatórias nao preenchidas. Preencha Numero de Convenio e CPF.");
        }
        unimedService.processaPagamento(paciente.getCpf(), paciente.getNumeroConvenio(), informacoesPagamento.getCpfMedico());
    }
}
