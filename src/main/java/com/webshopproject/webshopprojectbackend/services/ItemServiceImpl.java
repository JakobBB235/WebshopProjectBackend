package com.webshopproject.webshopprojectbackend.services;

import com.webshopproject.webshopprojectbackend.dto.ItemDto;
import com.webshopproject.webshopprojectbackend.models.Item;
import com.webshopproject.webshopprojectbackend.models.User;
import com.webshopproject.webshopprojectbackend.repositories.ItemRepository;
import com.webshopproject.webshopprojectbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ItemServiceImpl implements ItemService{

    private ItemRepository itemRepository;
    private UserService userService;
    private UserRepository userRepository;

//    public ItemServiceImpl(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

//    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
//        this.itemRepository = itemRepository;
//        this.userService = userService;
//    }

    public ItemServiceImpl(ItemRepository itemRepository, UserService userService, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    @Override
//    public ItemDto addItem(ItemDto itemDto) {
////        Item item = itemDto.convertToItem();
////        return itemRepository.save(item).convertToDto();
//
//        Item item = itemDto.convertToItem();
////        User owner = userService.getUser(itemDto.getUserId()).convertToUser(); //Use repository instead to avoid convert?
////        System.out.println(itemDto.getUserId());
////        System.out.println(owner.getUsername());
//        User owner = userRepository.findById(itemDto.getUserId()).orElse(null);
//        owner.getItems().add(item); //needed? save this aswell? To ensure updating both sides of the relationship
//        item.setUser(owner);
//        item.setActive(true); //Or make default in the model itself
//
//        return itemRepository.save(item).convertToDto();
//    }

//    @Override
//    public ItemDto addItem(ItemDto itemDto) {
////        Item item = itemDto.convertToItem();
////        return itemRepository.save(item).convertToDto();
//
//        Item item = itemDto.convertToItem();
//
//        User owner = userRepository.findById(itemDto.getUserId()).orElse(null);
//        item.setActive(true); //Or make default in the model itself
//        owner.addItem(item); //To ensure updating both sides of the relationship
//
////        return itemRepository.save(item).convertToDto();
//        userRepository.save(owner);
//        return
//    }

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = itemDto.convertToItem();
        User owner = userRepository.findById(itemDto.getUserId()).orElse(null);
        item.setActive(true); //Or make default in the model itself
        item.addOwner(owner); //To ensure updating both sides of the relationship. ??? item is added without id?

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
        Item item = itemRepository.findById(itemDto.getItemId()).orElse(null);
//        User owner = userService.getUser(itemDto.getUserId()).convertToUser();
//        User owner = userRepository.findById(itemDto.getUserId()).orElse(null);
        item.convertToItem(itemDto);
//        item.setUser(owner); //No need since item should already have a owner
        item.setDateTimeEdited(new Date());

        //Update user side?
//        Item olditem = owner.getItems().stream().findFirst().

//        List<Item> ownerItems = owner.getItems();
//        //Find item(use stream instead)
//        for(int i = 0; i < ownerItems.size(); i++){
//            if (ownerItems.get(i).getItemId() == item.getItemId()){
//                ownerItems.set(i, item);
//                break;
//            }
//        }
//        item.setUser(owner);
        itemRepository.save(item);
    }

}
