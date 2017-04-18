package com.my.project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "foodsupplier_table")
@PrimaryKeyJoinColumn(name = "personID")
public class FoodSupplier extends Person {

	@OneToOne(mappedBy = "foodSupplier" , cascade = CascadeType.ALL)
	private Email email;
	
	@ManyToOne
	private Admin admin;
	
	@Column(name = "userName")
	private String username;

	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "foodSupplier" , cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(mappedBy = "foodSupplier" , cascade = CascadeType.ALL)
	private Menu menu;
	
	@Column(name = "phoneDetails")
	private int phoneDetails;
	
	@Column(name = "cardDetails")
	private String cardDetails;

	public FoodSupplier() {
	
		
	}
	
	

	public FoodSupplier(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}


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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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
	
	
}
