package com.springrest.Second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewController {
    @Autowired
    ProductServices productServices;

    @GetMapping("/greet")
    public String greet(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/Products")
    public String addProduct(@RequestBody Product p){
        productServices.save(p);
        return "Product Saved";
    }
    @GetMapping("/Products")
    public List<Product> getProducts(){
        List<Product> p = productServices.findAll();
        return p;
    }
    @GetMapping("/Products/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int id){
        Optional<Product> p = productServices.findById(id);
        return p;
    }

    @DeleteMapping("/Products/{id}")
    public String delProduct(@PathVariable("id") int id){
        productServices.delete(productServices.getOne(id));
        return "Product Deleted";
    }
}
