package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Event;
import br.com.projeto.arenapernambuco.repository.EventRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public String listEvents(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String q,
            @RequestParam(required = false, defaultValue = "date") String sort,
            Model model
    ) {
        List<Event> events;

        if (category != null && !category.isBlank()) {
            events = eventRepository.findByCategory_NameIgnoreCase(category);
        } else if (q != null && !q.isBlank()) {
            events = eventRepository.findByTitleContainingIgnoreCase(q);
        } else {
            events = eventRepository.findAll();
        }

        // Aplicar ordenação
        switch(sort.toLowerCase()) {
            case "price_asc":
                events.sort((e1, e2) -> e1.getFullPrice().compareTo(e2.getFullPrice()));
                break;
            case "price_desc":
                events.sort((e1, e2) -> e2.getFullPrice().compareTo(e1.getFullPrice()));
                break;
            case "popular":
                // Você pode adicionar um campo "tickets_sold" na entidade Event
                break;
            case "date":
            default:
                events.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate()));
                break;
        }

        model.addAttribute("events", events);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("q", q);
        model.addAttribute("sort", sort);

        return "events";
    }
}

