package br.com.zup.investimentos;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SimulacaoDTO {
    @Email(message = "email inválido")
    private String email;

    @NotBlank
    @Size(min = 2, max = 30, message = "O nome deve ter entre 2 e 30 caracteres")
    private String nome;

    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank
    private double valorInvestido;

    @NotBlank
    private int meses;

    @NotEmpty
    private TipodeRisco risco;

    public SimulacaoDTO() {

    }


}
