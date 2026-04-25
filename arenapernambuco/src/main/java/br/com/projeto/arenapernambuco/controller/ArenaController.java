package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArenaController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public String listarEventos(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @GetMapping("/compra/{id}")
    public String detalhesEvento(@PathVariable Long id, Model model) {
        return eventRepository.findById(id)
            .map(evento -> {
                model.addAttribute("evento", evento);
                return "compra";
            }).orElse("redirect:/events");
    }
}