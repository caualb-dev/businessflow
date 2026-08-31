package com.caualb.businessflow.domain.user;

import com.caualb.businessflow.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UserDados(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @CPF(message = "CPF formato invalido")
        @NotBlank(message = "CPF é obrigatorio")
        String cpf,
        @Email
        @NotBlank
        String email,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {
}
