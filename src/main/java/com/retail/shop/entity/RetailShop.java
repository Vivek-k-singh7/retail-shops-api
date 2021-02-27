package com.retail.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RetailShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "category")
	private String category;

	@Column(name = "location_lat")
	private Integer locationLat;

	@Column(name = "location_lng")
	private Integer locationLng;

	public RetailShop() {
	}

	public RetailShop(Integer id, String owneName, String shopName, String category, Integer locationLat,
			Integer locationLng) {
		this.id = id;
		this.ownerName = owneName;
		this.shopName = shopName;
		this.locationLat = locationLat;
		this.locationLng = locationLng;
	}
}
