package br.org.senai.conveniospagamento.entities;

public class InformacoesPagamento {
    private String cpfMedico;
    private String idTransacaoPix;

    public String getCpfMedico() {
        return cpfMedico;
    }

    public void setCpfMedico(String cpfMedico) {
        this.cpfMedico = cpfMedico;
    }

    public String getIdTransacaoPix() {
        return idTransacaoPix;
    }

    public void setIdTransacaoPix(String idTransacaoPix) {
        this.idTransacaoPix = idTransacaoPix;
    }
}
