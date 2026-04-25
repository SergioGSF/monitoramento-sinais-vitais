package br.com.projeto.arenapernambuco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }
}