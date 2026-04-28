package br.com.projeto.arenapernambuco.repository;

import br.com.projeto.arenapernambuco.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByCategory_NameIgnoreCase(String categoryName);
    List<Evento> findByTitleContainingIgnoreCase(String title);
}
