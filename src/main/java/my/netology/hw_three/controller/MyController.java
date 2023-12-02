package my.netology.hw_three.controller;

import my.netology.hw_three.services.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("products/fetch-product")
    public List<String> getProducts(@RequestParam String name) {
        return service.getProducts(name);
    }
}
