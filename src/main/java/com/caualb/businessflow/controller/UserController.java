package com.caualb.businessflow.controller;

import com.caualb.businessflow.domain.user.DadosDetalhamentoUser;
import com.caualb.businessflow.domain.user.DadosListagemUser;
import com.caualb.businessflow.domain.user.User;
import com.caualb.businessflow.domain.user.UserAtualizarDados;
import com.caualb.businessflow.domain.user.UserDados;
import com.caualb.businessflow.domain.user.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid UserDados dados, UriComponentsBuilder uriBuilder) {
        var user = new User(dados);
        repository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUser>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemUser::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid UserAtualizarDados dados) {
        var user = repository.getReferenceById(dados.id());
        user.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoUser(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        user.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUser(user));
    }
}
