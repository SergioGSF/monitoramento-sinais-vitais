package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Compra;
import br.com.projeto.arenapernambuco.model.Evento;
import br.com.projeto.arenapernambuco.repository.CompraRepository;
import br.com.projeto.arenapernambuco.repository.EventoRepository;
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

    // TELA: MEUS INGRESSOS
    @GetMapping("/meus-ingressos")
    public String meusIngressos(Model model, Principal principal) {
        String emailLogado = principal.getName();
        List<Compra> ingressos = compraRepository.findByEmail(emailLogado);
        model.addAttribute("ingressos", ingressos);
        return "meus-ingressos";
    }

    // AÇÃO: PROCESSAR COMPRA (Resolve o Erro 405)
    @PostMapping("/confirmacao")
    public String processarCompra(@RequestParam("eventId") Long eventId,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  Principal principal) {
        Evento evento = eventoRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Compra novaCompra = new Compra();
        novaCompra.setEvent(evento);
        novaCompra.setNome(nome);
        novaCompra.setCpf(cpf);
        novaCompra.setEmail(principal.getName());

        compraRepository.save(novaCompra);
        return "confirmacao";
    }

    // AÇÃO: CANCELAR INGRESSO
    @PostMapping("/cancelar-ingresso/{id}")
    public String cancelarIngresso(@PathVariable("id") Long id) {
        compraRepository.deleteById(id);
        return "redirect:/meus-ingressos";
    }
}