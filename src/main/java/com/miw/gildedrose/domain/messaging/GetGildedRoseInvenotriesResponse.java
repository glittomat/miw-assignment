package com.miw.gildedrose.domain.messaging;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miw.gildedrose.domain.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties({"messages", "action"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GetGildedRoseInvenotriesResponse implements Serializable{
	 /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5806030075431033853L;

    /** The trading list profile entity. */
//   @Getter @Setter private List<Item> itemEntities;
   
   private List<Item> itemEntities;

    

//    public GetGildedRoseInvenotriesResponse(List<Item> itemEntities) {
//		super();
//		this.itemEntities = itemEntities;
//	}
//
//	/**
//     * Gets the entity.
//     *
//     * @return the entity
//     */
//    public List<Item> getItemEntities() {
//        return itemEntities;
//    }

    // Not needed works wih lomobok equal & hashoce
//    @Override
//    public boolean equals(Object object) {
//        return super.equals(object);
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }

}
