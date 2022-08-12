package com.miw.gildedrose.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class item.
 *
 */
@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Item implements Serializable //SearchEntity,
{
	
	private static final long serialVersionUID = -2867929509389260601L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
//	@Id
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
//	
	@Schema(description = "The InventoryName", required = true)
	@JsonPropertyDescription(value = "JSON The InventoryName.")
	public String name;
	
	@Schema(description = "The Inventory Description.", required = true)
	@JsonPropertyDescription(value = "JSON The Inventory Description.")
    public String description;
	
	@Schema(description = "The Inventory Price", required = true)
	@JsonPropertyDescription(value = "JSON The Inventory Price")
    public double price;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "itemEntities")
	private List<BuyItemDetails> orderItems;

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Item(Long id, String name, String description, double price, List<BuyItemDetails> orderItems) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public List<BuyItemDetails> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<BuyItemDetails> orderItems) {
		this.orderItems = orderItems;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.name).toHashCode();
    }
	
	 @Override
	    public boolean equals(Object obj) {
	        if (!(obj instanceof Item)) {
	            return false;
	        }
	        if (obj == this) return true;
	        
	        Item item = (Item) obj;
	        return new EqualsBuilder().append(this.id, item.id)
	                .append(this.name, item.name).isEquals();
	    }
//    
//    /** The total records count. */
//    @JsonIgnore  
//    private int totalRecordsCount;
    
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
	
//
//    @Override
//    public int getTotalRecordsCount() {
//        return totalRecordsCount;
//    }
//
//    public void setTotalRecordsCount(int totalRecordsCount) {
//        this.totalRecordsCount = totalRecordsCount;
//    }

    
}
