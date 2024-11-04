package com.example.demo.Controllers;

import com.example.demo.Entity.ProductEntity;
import com.example.demo.Service.UService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class Controler {
//    private final UService uService;
//
//    @Autowired
//    public Controler(UService uService) {
//        this.uService = uService;
//    }
    @Autowired
    UService uService;



    @GetMapping("/items")
    public ProductEntity getItem(@RequestParam int id) {
        return uService.getProduct(id);
    }
    @PutMapping("/items")
    public ProductEntity updateItem(@RequestBody ProductEntity item) {
        return uService.updateProduct(item);

    }
 @PostMapping("/items")
 public ProductEntity addItem(@RequestBody ProductEntity item) {
     return uService.saveProduct(item);
}
@DeleteMapping("/items")
    public ProductEntity deleteItem(@RequestBody ProductEntity item) {
        return uService.deleteProduct(item);
    }


}

