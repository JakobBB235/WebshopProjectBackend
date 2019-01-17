package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(long id) {
        return itemRepository.findById(id).orElse(null); //.getOne(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(Item item) { //Merge with addItem and rename saveItem?
//        Item oldItem = itemRepository.findById(item.getItemId()).orElse(null);
//        oldItem.setInStock(item.getInStock());
//        oldItem.setName(item.getName());
//        itemRepository.save(oldItem);

        itemRepository.save(item);
    }
}
