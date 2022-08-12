package com.miw.gildedrose.domain.messaging;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.miw.gildedrose.domain.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GetGildedRoseInvenotryResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8393269586229334916L;
	

    /** The trading list profile entity. */
//   @Getter @Setter private Item item;
	
	private Item item;
   

//	public GetGildedRoseInvenotryResponse() {
//		super();
//	}
//
//
//	public GetGildedRoseInvenotryResponse(Item item2) {
//		super();
//		this.item = item2;
//	}
//
//
//	public Item getItem() {
//		return item;
//	}
//
//
//	public void setItem(Item item) {
//		this.item = item;
//	}
	
	
}
