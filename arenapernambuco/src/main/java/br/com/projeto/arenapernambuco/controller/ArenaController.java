package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Compra;
import br.com.projeto.arenapernambuco.repository.CompraRepository;
import br.com.projeto.arenapernambuco.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArenaController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping("/events")
    public String listarEventos(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String q,
            Model model) {

        var events = eventRepository.findAll();

        if (category != null && !category.isEmpty()) {
            events = events.stream()
                    .filter(e -> e.getCategory() != null
                            && e.getCategory().getName().equalsIgnoreCase(category))
                    .toList();
        }

        if (q != null && !q.isEmpty()) {
            events = events.stream()
                    .filter(e -> e.getTitle() != null
                            && e.getTitle().toLowerCase().contains(q.toLowerCase()))
                    .toList();
        }

        model.addAttribute("events", events);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("q", q);

        return "events";
    }

    @GetMapping("/compra/{id}")
    public String detalhesEvento(@PathVariable Long id, Model model) {
        return eventRepository.findById(id)
                .map(evento -> {
                    model.addAttribute("evento", evento);
                    return "compra";
                })
                .orElse("redirect:/events");
    }

    @GetMapping("/pagamento/{id}")
    public String pagamento(@PathVariable Long id, Model model) {
        return eventRepository.findById(id)
                .map(evento -> {
                    model.addAttribute("evento", evento);
                    return "pagamento";
                })
                .orElse("redirect:/events");
    }

    @PostMapping("/finalizar-compra")
    public String finalizarCompra(
            Compra compra,
            @RequestParam Long eventId
    ) {
        var evento = eventRepository.findById(eventId).orElse(null);
        compra.setEvent(evento);
        compraRepository.save(compra);
        return "redirect:/confirmacao";
    }

    @GetMapping("/confirmacao")
    public String confirmacao() {
        return "confirmacao";
    }
}