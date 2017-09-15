package com.cg.core.pms.dto;

//Bean
public class Product 
{
	private int id;
	private String name;
	private float price;
	private String category;
	private int quantity;
	public Product() {
	
		// TODO Auto-generated constructor stub
	}
	public Product(String name, float price, String category, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	public Product(int id, String name, float price, String category,
			int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", quantity=" + quantity + "]";
	}
	
	
	
}
