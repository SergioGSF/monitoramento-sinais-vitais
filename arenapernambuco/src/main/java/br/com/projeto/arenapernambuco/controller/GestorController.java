package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Evento;
import br.com.projeto.arenapernambuco.repository.CompraRepository;
import br.com.projeto.arenapernambuco.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gestor")
public class GestorController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pendentes", eventoRepository.findByStatus(Evento.Status.PENDENTE));
        model.addAttribute("todos", eventoRepository.findAll());
        return "gestor-dashboard";
    }

    @PostMapping("/aprovar/{id}")
    public String aprovar(@PathVariable Long id) {
        eventoRepository.findById(id).ifPresent(e -> {
            e.setStatus(Evento.Status.APROVADO);
            eventoRepository.save(e);
        });
        return "redirect:/gestor/dashboard";
    }

    @PostMapping("/cancelar/{id}")
    public String cancelar(@PathVariable Long id) {
        eventoRepository.findById(id).ifPresent(e -> {
            e.setStatus(Evento.Status.CANCELADO);
            eventoRepository.save(e);
        });
        return "redirect:/gestor/dashboard";
    }

    @GetMapping("/agenda")
    public String agenda(Model model) {
        List<Evento> aprovados = eventoRepository.findByStatus(Evento.Status.APROVADO)
                .stream()
                .sorted(Comparator.comparing(Evento::getDate))
                .collect(Collectors.toList());
        model.addAttribute("eventos", aprovados);
        return "gestor-agenda";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        List<Evento> todos = eventoRepository.findAll();

        long totalEventos = todos.size();
        long aprovados = eventoRepository.countByStatus(Evento.Status.APROVADO);
        long pendentes = eventoRepository.countByStatus(Evento.Status.PENDENTE);
        long cancelados = eventoRepository.countByStatus(Evento.Status.CANCELADO);
        long totalIngressos = compraRepository.count();

        double receita = compraRepository.findAll().stream()
                .filter(c -> c.getEvent() != null && c.getEvent().getFullPrice() != null)
                .mapToDouble(c -> c.getEvent().getFullPrice())
                .sum();

        List<Evento> topEventos = todos.stream()
                .sorted((a, b) -> Long.compare(
                        compraRepository.countByEvent(b),
                        compraRepository.countByEvent(a)))
                .limit(5)
                .collect(Collectors.toList());

        Map<Evento, Long> ingressosPorEvento = new LinkedHashMap<>();
        for (Evento e : topEventos) {
            ingressosPorEvento.put(e, compraRepository.countByEvent(e));
        }

        model.addAttribute("totalEventos", totalEventos);
        model.addAttribute("aprovados", aprovados);
        model.addAttribute("pendentes", pendentes);
        model.addAttribute("cancelados", cancelados);
        model.addAttribute("totalIngressos", totalIngressos);
        model.addAttribute("receita", receita);
        model.addAttribute("ingressosPorEvento", ingressosPorEvento);
        return "gestor-stats";
    }
}
