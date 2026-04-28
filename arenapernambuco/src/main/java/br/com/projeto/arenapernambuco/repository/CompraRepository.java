package br.com.projeto.arenapernambuco.repository;

import br.com.projeto.arenapernambuco.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByEmail(String email);
}