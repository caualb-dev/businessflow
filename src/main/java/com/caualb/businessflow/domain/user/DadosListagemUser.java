package com.caualb.businessflow.domain.user;

public record DadosListagemUser(Long id, String nome, String email, String cpf, Especialidade especialidade) {

    public DadosListagemUser(User user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getCpf(), user.getEspecialidade());
    }
}
