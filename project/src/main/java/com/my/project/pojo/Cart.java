package com.my.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_table")
public class Cart implements Serializable {
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="foodItem_id")
	private FoodItem foodItem;
	
	@Column(name="quantity")
	private int quantity;
	
	
	
	public Cart() {
		super();
	
	}
	
	
	

	public FoodItem getFoodItem() {
		return foodItem;
	}




	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}




	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

}
