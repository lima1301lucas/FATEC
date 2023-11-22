package com.esiii.backendjogodaonca.repository.database;

import com.esiii.backendjogodaonca.entities.database.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Override
    ArrayList<Item> findAll();
}