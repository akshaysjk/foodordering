package com.my.project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.my.project.pojo.User;

@Entity
@Table(name = "email_table")
@PrimaryKeyJoinColumn(name = "personID")
public class Email {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@GenericGenerator(name = "generator", strategy="foreign", parameters= {@Parameter(name = "property", value="user"),@Parameter(name = "property", value="foodSupplier")})
	@Column(name="emailID", unique=true,nullable = false)
	private long emailID;
	
	@Column(name="emailAddress")
	private String emailAddress;

	@OneToOne//(cascade = CascadeType.ALL)
	//@JoinColumn(name="userid", nullable=true)
	private User user;
	
	@OneToOne//(cascade = CascadeType.ALL)
	//@JoinColumn(name="foodSupplierid", nullable=true)
	private FoodSupplier foodSupplier;

	public Email() {
	}

	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

	public FoodSupplier getFoodSupplier() {
		return foodSupplier;
	}

	public void setFoodSupplier(FoodSupplier foodSupplier) {
		this.foodSupplier = foodSupplier;
	}

	
	
	public long getEmailID() {
		return emailID;
	}

	public void setEmailID(long emailID) {
		this.emailID = emailID;
	}

	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}