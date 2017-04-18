package com.my.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "admin_table")
@PrimaryKeyJoinColumn(name = "personID")
public class Admin extends Person{

	
	@Column(name = "userName")
	private String username;

	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FoodSupplier> foodSuppliers = new HashSet<FoodSupplier>();
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<User>();
	
	public Set<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add( user );
        user.setAdmin( this );
    }

    public void removeUsers(User user) {
    	users.remove( user );
        user.setAdmin( null );
    }
    
	public Set<FoodSupplier> getFoodSuppliers() {
        return foodSuppliers;
    }

    public void addFoodSupliers(FoodSupplier foodSupplier) {
        foodSuppliers.add(foodSupplier );
        foodSupplier.setAdmin( this );
    }

    public void removeFoodSuppliers(FoodSupplier foodSupplier) {
    	foodSuppliers.remove(foodSupplier);
        foodSupplier.setAdmin( null );
    }
}
