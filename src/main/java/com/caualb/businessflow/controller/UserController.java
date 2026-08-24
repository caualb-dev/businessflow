package com.caualb.businessflow.controller;

import com.caualb.businessflow.dto.response.DadosListagemUser;
import com.caualb.businessflow.dto.request.UserDados;
import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid UserDados dados){
        repository.save(new User(dados));
    }

    @GetMapping
    public Page<DadosListagemUser> listar(@PageableDefault(size = 10 , sort = {"nome"}) Pageable paginacao) {
    return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUser::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid UserAtualizarDados dados){
        var user = repository.getReferenceById(dados.id());
        user.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        user.excluir();

    }


}
