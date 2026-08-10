package com.caualb.businessflow.dto;

import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.model.enums.Especialidade;

public record DadosListagemUser(String nome, String email, String cpf, Especialidade especialidade) {

    public DadosListagemUser(User user){
        this(user.getNome(), user.getCpf(), user.getEmail(), user.getEspecialidade());
    }
}
