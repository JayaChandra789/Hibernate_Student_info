package com.mystudent.hibernate.student.student_hibernate.product;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import jakarta.persistence.*;
/*question:-Create a simple hibernate program to insert and update Entity.
Entity Name : Product
----------------------------------------------
Fields:-
productId-string
productName-String
price:float
quantity:int*/
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table (name="product_details")
public class Product 
{
	/*--------Attributes--------*/
	@Id
	private String productId;
	@Column(name="product_name",length = 300,nullable = false)
	private String name;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private int quantity;
	/*--------Parameterized Constructor--------*/
	public Product(String productId, String name, float price, int quantity) 
	{
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	/*--------Default Constructor--------*/
	public Product() 
	{
		super();
	}
	/*--------Getter and Setters--------*/
	public String getProductId() {return productId;}
	public void setProductId(String productId) {this.productId = productId;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public float getPrice() {return price;}
	public void setPrice(float price) {this.price = price;}

	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	/*--------To string method to show every data in String format--------*/
	@Override
	public String toString() 
	{
		return  "\n productId: " + productId +
				"\n name: " 	 + name + 
				"\n price: "     + price + 
				"\n quantity: "  + quantity;
	}	
}
