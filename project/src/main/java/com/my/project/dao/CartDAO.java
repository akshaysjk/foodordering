package com.my.project.dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import com.my.project.exception.FoodSupplierException;
import com.my.project.pojo.Cart;
import com.my.project.pojo.FoodItem;
import com.my.project.pojo.User;

public class CartDAO extends DAO{
	
	public CartDAO()
	{
		
	}
	
	
	public void addEntry(User user,FoodItem foodItem, int quantity)throws FoodSupplierException
	{
		try{
		begin();
		Cart cart = new Cart();
		System.out.println(user.getFirstName());
		cart.setFoodItem(foodItem);
		cart.setQuantity(quantity);
		cart.setUser(user);
		getSession().save(cart);
		commit();
		}
		catch(HibernateException e)
		{
			rollback();
			throw new FoodSupplierException("Cart not created " + foodItem, e);
		}
		
	}

}
