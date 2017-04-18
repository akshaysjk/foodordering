package com.my.project.pojo;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="address_table")
public class Address {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressID", unique=true,nullable = false)
	private long addressID;
	
	@Column(name="area")
	private String area;
	
	@Transient
	private Integer remove;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private FoodSupplier foodSupplier;

	public Address() {
		
	}

	
	
	public FoodSupplier getFoodSupplier() {
		return foodSupplier;
	}
	
	



	public Integer getRemove() {
		return remove;
	}



	public void setRemove(Integer remove) {
		this.remove = remove;
	}



	public void setFoodSupplier(FoodSupplier foodSupplier) {
		this.foodSupplier = foodSupplier;
	}



	public Address(String area, String city, String state, String zipcode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public long getAddressID() {
		return addressID;
	}

	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
