package com.caualb.businessflow.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByAtivoTrue(Pageable paginacao);
}
