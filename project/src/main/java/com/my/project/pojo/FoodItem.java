package com.my.project.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="fooditem_table")
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fooditemID", unique=true, nullable = false)
	private long fooditemID;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	private Menu menu;
	
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private long price;
	
	@Column(name="type")
	private String type;
	
	@Column(name="quantity")
	private int qunatity;
	
	@OneToMany(mappedBy = "foodItem")
	private List<Cart> cart;
	
	
	public FoodItem() {
		
		
	}

	



	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
	}



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public long getFooditemID() {
		return fooditemID;
	}

	public void setFooditemID(long fooditemID) {
		this.fooditemID = fooditemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}





	public List<Cart> getCart() {
		return cart;
	}





	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}




	
	

}
