package br.com.zup.investimentos;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

public class SimulacaoDTO {
    @Email(message = "email inválido")
    private String email;

    @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    private String nome;

    @CPF(message = "CPF inválido")
    private String cpf;

    private double valorInvestido;

    @Min(2)
    @Max(12)
    private int periodoDeAplicacaoMeses;

    private TipodeRisco risco;

    public SimulacaoDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public int getPeriodoDeAplicacaoMeses() {
        return periodoDeAplicacaoMeses;
    }

    public void setMeses(int meses) {
        this.periodoDeAplicacaoMeses = meses;
    }

    public TipodeRisco getRisco() {
        return risco;
    }

    public void setRisco(TipodeRisco risco) {
        this.risco = risco;
    }
}
