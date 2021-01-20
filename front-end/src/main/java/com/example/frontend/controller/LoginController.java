package com.example.frontend.controller;

import com.example.frontend.dto.JwtRequest;
import com.example.frontend.service.FeignJwtRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final FeignJwtRequest feignJwtRequest;

    public LoginController(FeignJwtRequest feignJwtRequest) {
        this.feignJwtRequest = feignJwtRequest;
    }

    @GetMapping
    public String main(Model model) {
        JwtRequest jwtRequest = new JwtRequest();
        model.addAttribute("jwtRequest", jwtRequest);
        return "login";
    }

    @PostMapping("/getJwtToken")
    public String getJwtToken(@ModelAttribute JwtRequest jwtRequest) {
        return "redirect:/";
    }

}
