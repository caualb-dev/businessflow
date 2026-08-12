package com.caualb.businessflow.dto.response;

import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.model.enums.Especialidade;

public record DadosListagemUser(Long id, String nome, String email, String cpf, Especialidade especialidade) {

    public DadosListagemUser(User user){
        this( user.getId(), user.getNome(), user.getCpf(), user.getEmail(), user.getEspecialidade());
    }
}
