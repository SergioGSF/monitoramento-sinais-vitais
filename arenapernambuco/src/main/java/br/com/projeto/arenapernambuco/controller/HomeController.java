package br.com.projeto.arenapernambuco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Arena Pernambuco - API funcionando!";
    }
    
    @GetMapping("/test-db")
    @ResponseBody
    public String testDb() {
        return "Teste de conexão - verifique o console para logs do JPA";
    }
}