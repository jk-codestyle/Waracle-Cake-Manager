package com.example.frontend.controller;

import com.example.frontend.dto.CakeDto;
import com.example.frontend.service.FeignCakeRestClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CakeController {

    private final FeignCakeRestClient feignCakeRestClient;

    public CakeController(FeignCakeRestClient feignCakeRestClient) {
        this.feignCakeRestClient = feignCakeRestClient;
    }

    @GetMapping
    public String main(Model model, HttpServletRequest request) {
        Optional<Cookie> authorisation = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("Authorisation"))
                .findFirst();

        if (authorisation.isEmpty()) {
            return "login";
        }

        List<CakeDto> cakes = feignCakeRestClient.getAllCakes(authorisation.get().getValue());
        CakeDto cakeDto = new CakeDto();
        model.addAttribute("cakes", cakes);
        model.addAttribute("cakeDto", cakeDto);
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("cakeDto") CakeDto cakeDto, HttpServletRequest request) {
        Optional<Cookie> authorisation = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("Authorisation"))
                .findFirst();

        if (authorisation.isEmpty()) {
            return "login";
        }

        feignCakeRestClient.addNewCake(authorisation.get().getValue(), cakeDto);
        return "redirect:/";
    }
}
