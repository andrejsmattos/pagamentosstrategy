package br.org.senai.conveniospagamento.strategies;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.exceptions.RegraDeNegocioException;
import br.org.senai.conveniospagamento.services.BradescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BradescoPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private BradescoService bradescoService;

    @Override
    public FormaPagamento tipoDePagamento() {
        return FormaPagamento.CONVENIO_BRADESCO;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {

        if(paciente.getCpf() == null) {
            throw new RegraDeNegocioException("Informaão obrigatórias nao preenchidas. Preencha o CPF.");
        }
        bradescoService.processaPagamento(paciente.getCpf(), informacoesPagamento.getCpfMedico(), valor);
    }
}
