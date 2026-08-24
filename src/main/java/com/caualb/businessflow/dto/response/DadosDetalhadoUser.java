package com.caualb.businessflow.dto.response;

import com.caualb.businessflow.model.entity.Endereco;
import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.model.enums.Especialidade;

public record DadosDetalhadoUser(Long id, String nome, String email, String telefone, String cpf, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhadoUser(User user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getTelefone(), user.getCpf(), user.getEspecialidade(), user.getEndereco());
    }
}
