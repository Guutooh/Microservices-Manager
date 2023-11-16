package com.br.microsservices.userapi.Repository;

import com.br.microsservices.userapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByCpf(String cpf);
    List<User> queryByNomeLike(String nome);

}
