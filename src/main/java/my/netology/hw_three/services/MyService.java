package my.netology.hw_three.services;

import my.netology.hw_three.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public List<String> getProducts(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return repository.getProductName(name);
    }
}
