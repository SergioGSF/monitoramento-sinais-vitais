package br.com.projeto.arenapernambuco.controller;

import br.com.projeto.arenapernambuco.model.Compra;
import br.com.projeto.arenapernambuco.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IngressoController {

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping("/meus-ingressos")
    public String meusIngressos(Model model) {
        List<Compra> ingressos = compraRepository.findAll();
        model.addAttribute("ingressos", ingressos);
        return "meus-ingressos";
    }

    @PostMapping("/cancelar-ingresso/{id}")
    public String cancelarIngresso(@PathVariable Long id) {
        compraRepository.deleteById(id);
        return "redirect:/meus-ingressos";
    }
}