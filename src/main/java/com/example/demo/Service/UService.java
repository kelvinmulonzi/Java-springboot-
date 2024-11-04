package com.example.demo.Service;

import com.example.demo.Repository.Repo;
import com.example.demo.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UService {
    @Autowired
    public Repo repo;

    public ProductEntity saveProduct (ProductEntity product) {
        return repo.save(product);
    }

    public ProductEntity deleteProduct (ProductEntity product) {
        repo.delete(product);
        return product;
    }
    public ProductEntity updateProduct (ProductEntity product) {
        return repo.save(product);
    }
    public ProductEntity getProduct (int id) {
        return repo.findById(id).orElse(null);
    }



    // A sample list to act as our in-memory "database"
private List<String> items = new ArrayList<>();



    // CREATE operation
    public String addItem(String item) {
        items.add(item);
        return "Item added: " + item;
    }

    // READ operation - Get all items
    public List<String> getItems() {
        return items;
    }

    // READ operation - Get item by index
    public String getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "Item not found";
    }

    // UPDATE operation
    public String updateItem(int index, String newItem) {
        if (index >= 0 && index < items.size()) {
            String oldItem = items.set(index, newItem);
            return "Item updated from: " + oldItem + " to: " + newItem;
        }
        return "Item not found";
    }

    // DELETE operation
    public String deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            String removedItem = items.remove(index);
            return "Item deleted: " + removedItem;
        }
        return "Item not found";
    }

    // DELETE operation - Delete all items
    public String deleteAllItems() {
        items.clear();
        return "All items deleted";
    }



    }


