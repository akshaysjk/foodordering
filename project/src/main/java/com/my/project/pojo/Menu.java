package com.my.project.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="menu_table")
public class Menu {
	
	@Id
    @GeneratedValue
    private Long id;
	
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> foodItems;

    @OneToOne
	@PrimaryKeyJoinColumn
	private FoodSupplier foodSupplier;
    
	public Menu() {
		
		this.foodItems = new ArrayList<FoodItem>();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public FoodSupplier getFoodSupplier() {
		return foodSupplier;
	}


	public void setFoodSupplier(FoodSupplier foodSupplier) {
		this.foodSupplier = foodSupplier;
	}


	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}


	public Menu(Long id) {
		
		this.id = id;
	}
	
	public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void addFoodItems(FoodItem foodItem) {
        foodItems.add( foodItem );
        foodItem.setMenu( this );
    }

    public void removeFoodItems(FoodItem foodItem) {
    	foodItems.remove( foodItem );
        foodItem.setMenu( null );
    }
	
    
    

}
