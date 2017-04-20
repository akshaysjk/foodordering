package com.my.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.project.exception.FoodSupplierException;
import com.my.project.pojo.FoodItem;

public class FoodItemDAO extends DAO {
	
	public FoodItemDAO ()
	{
		
	}
	
	
	public void updateFoodItem(long id,String foodItemName,String description,long price) throws FoodSupplierException {
		try {
			begin();
			String hql = "update FoodItem set name = :name, description = :description, price = :price WHERE fooditemID = :fooditemID";
		Query query = getSession().createQuery(hql);
		query.setParameter("name", foodItemName);
		query.setParameter("description", description);
		query.setLong("price", price);
		query.setLong("fooditemID", id);
		System.out.println("Id "+id+"description"+description+"foodItemName"+foodItemName+"Price"+price);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not delete foodItem " +foodItemName, e);
		}
	}
	
	public FoodItem getFoodItem(int foodItemId) throws FoodSupplierException
	{
		try {
			begin();
			Query q = getSession().createQuery("from FoodItem where fooditemID= :fooditemID");
			q.setInteger("fooditemID", foodItemId);		
			FoodItem fi = (FoodItem) q.uniqueResult();
			System.out.println("Got the foodItem with ID" +fi.getFooditemID());
			//commit();
			return fi;
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get foodItem " + foodItemId, e);
		}
	}
	
	public List<FoodItem> getFoodItems(long menuId) throws FoodSupplierException
	{
		try {
			begin();
			Query q = getSession().createQuery("from FoodItem where menu= :menuId");
			q.setLong("menuId", menuId);		
			List<FoodItem> fi = q.list();
			//commit();
			return fi;
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get foodItem " + menuId, e);
		}
	}
	
	public void deleteFoodItem(int foodItemID) throws FoodSupplierException
	{
		try {
			begin();
			FoodItem fi= getFoodItem(foodItemID);
			System.out.println("FoodItem "+fi.getName());
			Query q = getSession().createQuery("delete FoodItem where fooditemID = :fooditemID");
			q.setInteger("fooditemID", foodItemID);
			 
			int result = q.executeUpdate();
			System.out.println("Deleted Result"+result);
			commit();
			System.out.println("Deleted Successfuuly from DAO method");
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get foodItem " + foodItemID, e);
		}
	}


}
