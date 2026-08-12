package com.caualb.businessflow.controller;

import com.caualb.businessflow.dto.request.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record UserAtualizarDados(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco ) {

}
