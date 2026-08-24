package com.caualb.businessflow.controller;

import com.caualb.businessflow.model.entity.Endereco;
import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.model.enums.Especialidade;

public record DadosDetalhamentoUser(String nome, String cpf, String email, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoUser(User user){
        this(user.getNome(), user.getCpf(), user.getEmail(), user.getTelefone(), user.getEspecialidade(), user.getEndereco());
    }
}
