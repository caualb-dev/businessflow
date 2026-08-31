package com.caualb.businessflow.domain.user;

import com.caualb.businessflow.domain.endereco.DadosEndereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByAtivoTrue(Pageable paginacao);

//    @Modifying
//    @Query("UPDATE User u SET u.numero = :numero WHERE u.id = :id")
//    void atualizarNumero(@Param("id") Long id, @Param("numero") String numero);
}
