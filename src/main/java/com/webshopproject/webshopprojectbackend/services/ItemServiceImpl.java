package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.ItemDto;
import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.models.User;
import com.webshopproject.webshopprojectbackend.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;
    private UserService userService;

//    public ItemServiceImpl(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
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
//        Item item = itemDto.convertToItem();
//        return itemRepository.save(item).convertToDto();

        Item item = itemDto.convertToItem();
        User owner = userService.getUser(itemDto.getUserId()).convertToUser();
        owner.getItems().add(item); //needed? save this aswell? To ensure updating both sides of the relationship
        item.setUser(owner);

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
        User owner = userService.getUser(itemDto.getUserId()).convertToUser();
        //Update user side?
//        Item olditem = owner.getItems().stream().findFirst().
        List<Item> ownerItems = owner.getItems();

        //Find item(use stream instead)
        for(int i = 0; i < ownerItems.size(); i++){
            if (ownerItems.get(i).getItemId() == item.getItemId()){
                ownerItems.set(i, item);
                break;
            }
        }
        item.setUser(owner);
        itemRepository.save(item);
    }

}
