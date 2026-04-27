package br.com.projeto.arenapernambuco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngressoController {

    @GetMapping("/meus-ingressos")
    public String meusIngressos() {
        // O Spring vai procurar o arquivo templates/meus-ingressos.html
        return "meus-ingressos";
    }
}