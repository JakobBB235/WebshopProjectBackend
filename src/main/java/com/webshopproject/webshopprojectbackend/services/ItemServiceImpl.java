package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.ItemDto;
import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    @Override
//    public Item addItem(Item item){
//        return itemRepository.save(item);
//    }
//
//    @Override
//    public Item getItem(long id) {
//        return itemRepository.findById(id).orElse(null); //.getOne(id);
//    }
//
//    @Override
//    public List<Item> getAllItems() {
//        return itemRepository.findAll();
//    }
//
//    @Override
//    public void deleteItem(long id) {
//        itemRepository.deleteById(id);
//    }
//
//    @Override
//    public void updateItem(Item item) { //Merge with addItem and rename saveItem?
////        Item oldItem = itemRepository.findById(item.getItemId()).orElse(null);
////        oldItem.setInStock(item.getInStock());
////        oldItem.setName(item.getName());
////        itemRepository.save(oldItem);
//        item.setDateTimeEdited(new Date());
//        itemRepository.save(item);
//    }

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = itemDto.convertToItem();
        return itemRepository.save(item).convertToDto();
    }

    @Override
    public ItemDto getItem(long id) {
        Item item = itemRepository.findById(id).orElse(null);
//        Item item = itemRepository.findOne(id);
        return item.convertToDto();
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream().map(Item::convertToDto).collect(toList());
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        Item item = itemDto.convertToItem();
        item.setDateTimeEdited(new Date());
        itemRepository.save(item);
    }


//    public List<FeeDto> getAllFees() {
//        return feeRepository.findAll().stream().map(Fee::toDto).collect(toList());
//    }
}
