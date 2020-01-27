package com.study.cartService.controller;

import com.study.cartService.entity.Cart;
import com.study.cartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CartServiceController {

    @Autowired
    private CartRepository m_repository;

    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl;

    @RequestMapping("/")
    String caseDefault()
    {
        System.out.println("DefaultCase");
        return "DefaultCase";
    }

    @PostMapping("/createCart")
    void createCart(@RequestParam final String CN)
    {
        m_repository.save(new Cart(CN));
    }

    @PostMapping("/addToCart")
    void addToCart(@RequestParam final String CN,@RequestParam final String PN)
    {
        Cart l_cart = m_repository.findByCID(CN);

        ResponseEntity<String> response;

        //get customer id
        resourceUrl = "http://localhost:8081/getCID?CN=" + CN;
        response = restTemplate.getForEntity(resourceUrl, String.class);
        l_cart.getSelectedItems().add(response.getBody());

        //get product id
        resourceUrl = "http://localhost:8082/getPID?PN=" + PN;
        response = restTemplate.getForEntity(resourceUrl, String.class);
        l_cart.getSelectedItems().add(response.getBody());
    }

    @GetMapping("/showCart")
    String showDbe(@RequestParam final String CN)
    {
        Cart l_cart = m_repository.findByCID(CN);
        return l_cart.toString();
    }

    @GetMapping("/getCart")
    Cart getCart(@RequestParam final String CN)
    {
        Cart l_cart = m_repository.findByCID(CN);
        System.out.println("send Cart from Customer: " + l_cart.getCID());
        return l_cart;
    }

    @GetMapping("/showDb")
    String showDb() {
        String l_string = " ";
        for (Cart customer : m_repository.findAll()) {
            l_string += customer.toString() + " ";
        }
        return l_string;
    }
}