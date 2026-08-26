package com.caualb.businessflow.domain.user;

import com.caualb.businessflow.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record UserAtualizarDados(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
