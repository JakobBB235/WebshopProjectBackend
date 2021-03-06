package com.webshopproject.webshopprojectbackend.repositories;

import com.webshopproject.webshopprojectbackend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
