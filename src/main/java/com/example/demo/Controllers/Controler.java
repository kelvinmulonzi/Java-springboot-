package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controler {

    // A sample list to act as our in-memory "database"
    private List<String> items = new ArrayList<>();

    // CREATE operation
    @PostMapping("/items")
    public String addItem(@RequestBody String item) {
        items.add(item);
        return "Item added: " + item;
    }

    // READ operation - Get all items
    @GetMapping("/items")
    public List<String> getItems() {
        return items;
    }

    // READ operation - Get item by index
    @GetMapping("/items/{index}")
    public String getItem(@PathVariable int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "Item not found";
    }

    // UPDATE operation
    @PutMapping("/items/{index}")
    public String updateItem(@PathVariable int index, @RequestBody String newItem) {
        if (index >= 0 && index < items.size()) {
            String oldItem = items.set(index, newItem);
            return "Item updated from: " + oldItem + " to: " + newItem;
        }
        return "Item not found";
    }

    // DELETE operation
    @DeleteMapping("/items/{index}")
    public String deleteItem(@PathVariable int index) {
        if (index >= 0 && index < items.size()) {
            String removedItem = items.remove(index);
            return "Item deleted: " + removedItem;
        }
        return "Item not found";
    }

    // Simple test endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
