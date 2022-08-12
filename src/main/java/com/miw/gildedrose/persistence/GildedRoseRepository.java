package com.miw.gildedrose.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.miw.gildedrose.domain.Item;

public interface GildedRoseRepository extends JpaRepository<Item, Integer>{

  public Item findByName(String name);
  
  @Modifying
  @Query("update Item i set i.price = :price where i.id = :id")
  void updatePhone(@Param(value = "id") long id, @Param(value = "price") Double price);

}
