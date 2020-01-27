package controller;

import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.OrderRepository;

@RestController
public class OrderServiceController {

    @Autowired
    private OrderRepository m_repository;

    @GetMapping("/showDb")
    String showDb()
    {
        String l_string = "";
        for (Order customer : m_repository.findAll()) {
            l_string += customer.toString();
        }
        return l_string;
    }

    @PostMapping("/order")
    void order(@RequestParam final String firstName)
    {

    }
}
