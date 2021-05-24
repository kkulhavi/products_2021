package hr.tsd.demoproizvodi.controller;

import hr.tsd.demoproizvodi.model.Product;
import hr.tsd.demoproizvodi.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/ok")
    @ResponseBody
    public String home(){
        return "ok";
    }

    @GetMapping("")
    public List<Product> getProducts(){
        return productsRepo.findAll();
    }

    @PostMapping("")
    public void addProduct(@RequestBody Product product){
        productsRepo.save(product);
    }

    @PutMapping("")
    public void updateProduct(@RequestBody Product product){
        productsRepo.save(product);
    }

    @DeleteMapping("")
    public void deleteProduct(@RequestBody Product product){
        productsRepo.delete(product);
    }
}
