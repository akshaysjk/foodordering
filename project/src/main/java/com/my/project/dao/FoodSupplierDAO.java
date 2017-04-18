package com.my.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.project.exception.FoodSupplierException;
import com.my.project.exception.UserException;
import com.my.project.pojo.Address;
import com.my.project.pojo.Email;
import com.my.project.pojo.FoodItem;
import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Menu;
import com.my.project.pojo.User;

public class FoodSupplierDAO extends DAO{

	public FoodSupplierDAO() {
	}

	public FoodSupplier get(String username, String password) throws FoodSupplierException {
		try {
			begin();
			Query q = getSession().createQuery("from FoodSupplier where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			System.out.println(username);
			System.out.println(password);
			FoodSupplier user= (FoodSupplier) q.uniqueResult();
			System.out.println("Size"+q.list().size());
			System.out.println("FS"+user.getFirstName());
			commit();
			close();
			return user;
		}catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get user " + username, e);
		}
		catch (Exception e) {
			rollback();
			throw new FoodSupplierException("Could not get user " + username, e);
		}
		
		
	}
	
	public FoodSupplier updateMenu(int id,String foodType[],String fooditemname[],String description[],String price[]) throws FoodSupplierException {
		try {
			
			
			System.out.println("Inside FS DAO update 1");		
			FoodSupplier fs = get(id);
			System.out.println(fs.getFirstName());
			Menu menu = fs.getMenu();
			System.out.println("Menu"+menu.toString());
			List<FoodItem> list = menu.getFoodItems();
			System.out.println("Inside FS DAO update 2");
			for(int i =0;i<fooditemname.length;i++)
			{
				FoodItem foodItem = new FoodItem();
				System.out.println("Inside FS DAO update 3");
				foodItem.setName(fooditemname[i]);
				System.out.println("FoodItemName"+i+""+fooditemname[i]);
				foodItem.setDescription(description[i]);
				System.out.println("description"+i+""+description[i]);
				foodItem.setPrice(Long.parseLong(price[i]));
				System.out.println("price"+i+""+price[i]);
				foodItem.setType(foodType[i]);
				System.out.println("FoodType"+i+""+price[i]);
				foodItem.setMenu(menu);
				list.add(foodItem);
				
			}
			
			System.out.println("Inside FS DAO update 4");
			menu.setFoodItems(list);
			System.out.println("Inside FS DAO update 5");
			menu.setFoodSupplier(fs);
			System.out.println("Inside FS DAO update 6");
			fs.setMenu(menu);
			System.out.println("Inside FS DAO update 7");
			
			//getSession().save(fs);
			commit();
			close();
			return fs;
		} catch (HibernateException e) {
			rollback();
			System.out.println(e);
			throw new FoodSupplierException("Could not get foodSupplier "+e.getMessage());
		}
	}
	
	
	public FoodSupplier get(int foodSupplierId) throws FoodSupplierException {
		try {
			begin();
			Query q = getSession().createQuery("from FoodSupplier where personID= :personID");
			q.setInteger("personID", foodSupplierId);		
			FoodSupplier foodSuplier = (FoodSupplier) q.uniqueResult();
			//commit();
			return foodSuplier;
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get foodSupplier " + foodSupplierId, e);
		}
	}

	public FoodSupplier register(FoodSupplier u)
			throws FoodSupplierException {
		try {
			begin();
			System.out.println("inside FoodSupplierDAO");
			Address address =new Address(u.getAddress().getArea(),u.getAddress().getCity(),u.getAddress().getState(),u.getAddress().getZipcode());
//			address.setArea(u.getAddress().getArea());
//			address.setCity(u.getAddress().getCity());
//			address.setState(u.getAddress().getState());
//			address.setZipcode(u.getAddress().getZipcode());
			Email email = new Email(u.getEmail().getEmailAddress());
			Menu menu = new Menu();
			FoodSupplier foodSupplier = new FoodSupplier(u.getUsername(), u.getPassword());
            System.out.println(u.getFirstName());
            foodSupplier.setMenu(menu);
            foodSupplier.setFirstName(u.getFirstName());
            foodSupplier.setLastName(u.getLastName());
            foodSupplier.setCardDetails(u.getCardDetails());
            foodSupplier.setPhoneDetails(u.getPhoneDetails());
            
            System.out.println("Before Email");
            foodSupplier.setEmail(email);
            System.out.println("After Email");
            foodSupplier.setAddress(address);
            foodSupplier.setMenu(menu);
            System.out.println("After Address");
			email.setFoodSupplier(foodSupplier);
			System.out.println("After email");
			address.setFoodSupplier(foodSupplier);
			System.out.println("After Address");
			getSession().save(foodSupplier);
			commit();
			return foodSupplier;

		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Exception while creating foodSupplier: " + e.getMessage());
		}
	}

	public void delete(FoodSupplier foodSupplier) throws FoodSupplierException {
		try {
			begin();
			getSession().delete(foodSupplier);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not delete foodSupplier " + foodSupplier.getUsername(), e);
		}
	}
}
