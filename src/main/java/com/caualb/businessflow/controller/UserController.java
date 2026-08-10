package com.caualb.businessflow.controller;

import com.caualb.businessflow.dto.UserDados;
import com.caualb.businessflow.model.entity.User;
import com.caualb.businessflow.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public String testar(){

        return "deu certo essa poha";
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid UserDados dados){
        repository.save(new User(dados));
    }
}
