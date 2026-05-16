package br.com.projeto.arenapernambuco.repository;

import br.com.projeto.arenapernambuco.model.Evento;
import br.com.projeto.arenapernambuco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByCategory_NameIgnoreCase(String categoryName);
    List<Evento> findByTitleContainingIgnoreCase(String title);
    List<Evento> findByStatus(Evento.Status status);
    List<Evento> findByEmpresa(User empresa);
    List<Evento> findByStatusAndCategory_NameIgnoreCase(Evento.Status status, String categoryName);
    List<Evento> findByStatusAndTitleContainingIgnoreCase(Evento.Status status, String title);
    long countByStatus(Evento.Status status);
    long countByEmpresaAndStatus(User empresa, Evento.Status status);
}
