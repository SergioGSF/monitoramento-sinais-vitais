package br.com.projeto.arenapernambuco.repository;

import br.com.projeto.arenapernambuco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
<<<<<<< HEAD
    boolean existsByEmail(String email);
=======
>>>>>>> 2dca80b (Cadastro)
}