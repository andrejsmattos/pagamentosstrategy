package br.org.senai.conveniospagamento;

import br.org.senai.conveniospagamento.entities.FormaPagamento;
import br.org.senai.conveniospagamento.entities.InformacoesPagamento;
import br.org.senai.conveniospagamento.entities.PessoaPaciente;
import br.org.senai.conveniospagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoTesteComponent {

    @Autowired
    public PagamentoTesteComponent(PagamentoService pagamentoService) {
        PessoaPaciente paciente = new PessoaPaciente();
        InformacoesPagamento informacoesPagamento = new InformacoesPagamento();
        pagamentoService.processaPagamento(paciente, FormaPagamento.PIX, informacoesPagamento, 100.00f);
    }
}
