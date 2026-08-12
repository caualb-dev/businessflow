package com.caualb.businessflow.dto.request;

import com.caualb.businessflow.model.enums.Especialidade;
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
        @CPF
        String cpf,
        @Email
        String email,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {
}
