package br.com.projeto.arenapernambuco.repository;

import br.com.projeto.arenapernambuco.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}