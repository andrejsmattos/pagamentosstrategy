package br.org.senai.conveniospagamento.entities;

public class PessoaPaciente {

    private String numeroConvenio;
    private String cpf;
    private String numeroPis;
    private String ChavePix;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getNumeroPis() {
        return numeroPis;
    }

    public void setNumeroPis(String numeroPis) {
        this.numeroPis = numeroPis;
    }

    public String getChavePix() {
        return ChavePix;
    }

    public void setChavePix(String chavePix) {
        ChavePix = chavePix;
    }
}
