package com.example.dliu.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Cart {
	
	
	//cartId,userId,collectNumber,collectTime
	
	
/*	public Cart(int cartId, int userId, int collectNumber,
			Timestamp collectTime) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.collectNumber = collectNumber;
		this.collectTime = collectTime;
	}
	*/
	
	
	private int cartId;
	public Cart(int cartId, Product product, int userId, int collectNumber,
			Timestamp collectTime) {
		super();
		this.cartId = cartId;
		this.product= product;
		this.userId = userId;
		this.collectNumber = collectNumber;
		this.collectTime = collectTime;
	}
	
	public Cart(int cartId,int userId, int collectNumber,
			Timestamp collectTime) {
	
		this.cartId = cartId;
		this.userId = userId;
		this.collectNumber = collectNumber;
		this.collectTime = collectTime;
	}
	
	
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCollectNumber() {
		return collectNumber;
	}
	public void setCollectNumber(int collectNumber) {
		this.collectNumber = collectNumber;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Timestamp collectTime) {
		this.collectTime = collectTime;
	}
	private Product product;
	private int userId;
	private int collectNumber;
	private Timestamp collectTime;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
