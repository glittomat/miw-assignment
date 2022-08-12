package com.miw.gildedrose.domain.messaging;

import java.io.Serializable;
import java.util.List;

import com.miw.gildedrose.domain.BuyItemDetails;
import com.miw.gildedrose.domain.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyGildedRoseInvenotryRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 537371041683462687L;
	
	private BuyItemDetails buyItems;

//	public BuyGildedRoseInvenotryRequest(BuyItemDetails buyItems) {
//		super();
//		this.buyItems = buyItems;
//	}
//	
//	public BuyGildedRoseInvenotryRequest() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public BuyItemDetails getBuyItems() {
//		return buyItems;
//	}
//
//	public void setBuyItems(BuyItemDetails buyItems) {
//		this.buyItems = buyItems;
//	}
}
