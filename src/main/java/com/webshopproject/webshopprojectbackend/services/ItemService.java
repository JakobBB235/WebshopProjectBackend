package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.ItemDto;
import com.webshopproject.webshopprojectbackend.models.Item;

import java.util.List;

public interface ItemService {
//    Item addItem(Item item);
//    Item getItem(long id);
//    List<Item> getAllItems();
//    void deleteItem(long id);
//    void updateItem(Item item);
//    List<Item> myItems(int userId);

    ItemDto addItem(ItemDto itemDto);
    ItemDto getItem(long id);
    List<ItemDto> getAllItems();
    void deleteItem(long id);
    void updateItem(ItemDto itemDto);
}
