package com.caualb.businessflow.domain.user;

import com.caualb.businessflow.domain.endereco.Endereco;

public record DadosDetalhamentoUser(Long id, String nome, String email, String telefone, String cpf, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoUser(User user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getTelefone(), user.getCpf(), user.getEspecialidade(), user.getEndereco());
    }
}
