package com.my.project.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.my.project.pojo.Email;

@Entity
@Table(name = "user_table")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Person{
	
	 @GeneratedValue
	 @Column(name="userid")
	 private int userid;
	 
	
	
	public int getUserid() {
		return userid;
	}

	@Column(name = "userName")
	private String username;

	@Column(name = "password")
	private String password;

	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}

//	@Column(name = "userName")
//	private String username;
//
//	@Column(name = "password")
//	private String password;

	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	private Email email;
	
	@ManyToOne
	private Admin admin;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
	
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Cart> cart;
	
	@Column(name = "phoneDetails")
	private int phoneDetails;
	
	@Column(name = "cardDetails")
	private String cardDetails;
	
	
	




	public User() {
		super();
		//this.addresses = new ArrayList<Address>();
//		Address address = new Address();
//		addresses.add(address);
		this.cart = new ArrayList<Cart>();
		
	}
	
	

	public User(String username, String password,String personType) {
		this.username = username;
		this.password = password;
	}

//	public String getUsername() {
//		return username;
//	}

	
//	public Address getAddress() {
//		return address;
//	}
//
//
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}



//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getPhoneDetails() {
		return phoneDetails;
	}

	public void setPhoneDetails(int phoneDetails) {
		this.phoneDetails = phoneDetails;
	}

	public String getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	

	public List<Cart> getCart() {
		return cart;
	}



	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}



	public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddresses(Address address) {
    	
        addresses.add( address );
        address.setUser( this );
    }

    public void removeAddresses(Address address) {
    	addresses.remove( address );
        address.setUser( null );
    }
    
	

//    public void addFoodItems(FoodItem foodItem) {
//        foodItem.add( foodItem );
//        foodItem.setUser( this );
//    }
//
//    public void removeFoodItems(FoodItem foodItem) {
//    	foodItem.remove( foodItem );
//        foodItem.setUser( null );
//    }
	

}
