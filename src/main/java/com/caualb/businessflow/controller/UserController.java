package com.caualb.businessflow.controller;

import com.caualb.businessflow.dto.DadosListagemUser;
import com.caualb.businessflow.dto.UserDados;
import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Page<DadosListagemUser> listar(Pageable paginacao) {
    return repository.findAll(paginacao).map(DadosListagemUser::new);
    }


}
