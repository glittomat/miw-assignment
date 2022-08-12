package com.miw.gildedrose.domain;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class BuyItemDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2411113658406798981L;
	
	@Id
	@GeneratedValue
	private Long orderId;
	
	@Schema(description = "The InventoryItem", required = true)
	@JsonPropertyDescription(value = "JSON The InventoryItem.")
//	@OneToMany(targetEntity=Item.class, cascade = CascadeType.ALL, mappedBy = "id", fetch=FetchType.EAGER)
//	@JoinColumn(name = "fk_order_id", referencedColumnName = "orderId" )
//    @ElementCollection(targetClass=Item.class)
	@ManyToMany 
	@JoinTable(
			name = "order_items",
			joinColumns = @JoinColumn(name = "buyItemDetails_orderId"),
			inverseJoinColumns = @JoinColumn(name = "item_id"))	
	private List<Item> itemEntities;
	
	@Schema(description = "The InventoryItem", required = false)
	@JsonPropertyDescription(value = "JSON The InventoryItem.")
	private String userInfo;
	
	@Schema(description = "The InventoryItem", required = false)
	@JsonPropertyDescription(value = "JSON The InventoryItem.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime buyTime;

	
	public BuyItemDetails(Long orderId, List<Item> itemEntities, String userInfo, LocalDateTime buyTime) {
		super();
		this.orderId = orderId;
		this.itemEntities = itemEntities;
		this.userInfo = userInfo;
		this.buyTime = buyTime;
	}
	
	public BuyItemDetails() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(List<Item> itemEntities) {
		this.itemEntities = itemEntities;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public LocalDateTime getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(LocalDateTime buyTime) {
		this.buyTime = buyTime;
	}

	@Override
	public String toString() {
		return "BuyItemDetails [orderId=" + orderId + ", itemEntities=" + itemEntities + ", userInfo=" + userInfo
				+ ", buyTime=" + buyTime + "]";
	}	
	
	

}
