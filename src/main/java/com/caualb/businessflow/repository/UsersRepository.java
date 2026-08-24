package com.caualb.businessflow.repository;

import com.caualb.businessflow.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByAtivoTrue(Pageable paginacao);
}
