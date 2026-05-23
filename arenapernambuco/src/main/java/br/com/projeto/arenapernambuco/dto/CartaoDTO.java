package br.com.projeto.arenapernambuco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CartaoDTO {

    @NotBlank(message = "Número do cartão obrigatório")
    @Pattern(
        regexp = "^[0-9]{16}$",
        message = "Número do cartão inválido"
    )
    private String numeroCartao;

    @NotBlank(message = "Nome obrigatório")
    @Size(min = 3, max = 100)
    private String nomeTitular;

    @NotBlank(message = "Validade obrigatória")
    @Pattern(
        regexp = "^(0[1-9]|1[0-2])\\/([0-9]{2})$",
        message = "Formato correto MM/AA"
    )
    private String validade;

    @NotBlank(message = "CVV obrigatório")
    @Pattern(
        regexp = "^[0-9]{3,4}$",
        message = "CVV inválido"
    )
    private String cvv;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}