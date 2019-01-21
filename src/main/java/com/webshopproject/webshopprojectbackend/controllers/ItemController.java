package com.webshopproject.webshopprojectbackend.controllers;

import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id){
        return itemService.getItem(id);
    }

    @PostMapping("/item")
    public Item addItem(@RequestBody Item item){ //should return the new item with id?
        return itemService.addItem(item);
    }

    @PutMapping("/item/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable Long id){ //params correct?
        itemService.updateItem(item);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }
}
