package com.miw.gildedrose.persistence;

import org.springframework.data.repository.CrudRepository;

import com.miw.gildedrose.domain.Item;

public interface GildedRoseDao extends CrudRepository<Item, String>{

}
