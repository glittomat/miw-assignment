package com.miw.gildedrose.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miw.gildedrose.domain.BuyItemDetails;

public interface BuyGlidedRoseRepository extends JpaRepository<BuyItemDetails, Integer> {

}
