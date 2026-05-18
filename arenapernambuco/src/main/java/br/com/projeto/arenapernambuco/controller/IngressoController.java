package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Compra;
import br.com.projeto.arenapernambuco.model.Evento;
import br.com.projeto.arenapernambuco.repository.CompraRepository;
import br.com.projeto.arenapernambuco.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class IngressoController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/meus-ingressos")
    @Transactional
    public String meusIngressos(Model model, Principal principal) {
        String emailLogado = principal.getName();
        List<Compra> ingressos = compraRepository.findByEmail(emailLogado);
        model.addAttribute("ingressos", ingressos);
        return "meus-ingressos";
    }

    @PostMapping("/confirmacao")
    @Transactional
    public String processarCompra(@RequestParam("eventId") Long eventId,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam(value = "quantidade", defaultValue = "1") int quantidade,
                                  Principal principal) {

        Evento evento = eventoRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        for (int i = 0; i < quantidade; i++) {
            Compra novaCompra = new Compra();
            novaCompra.setEvent(evento);
            novaCompra.setNome(nome);
            novaCompra.setCpf(cpf);
            novaCompra.setEmail(principal.getName());
            compraRepository.save(novaCompra);
        }

        return "redirect:/confirmacao";
    }

    @PostMapping("/cancelar-ingresso/{id}")
    public String cancelarIngresso(@PathVariable("id") Long id) {
        compraRepository.deleteById(id);
        return "redirect:/meus-ingressos";
    }
}
