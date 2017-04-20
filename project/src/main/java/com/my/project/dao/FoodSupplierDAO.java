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
	
	public List<FoodSupplier> list() throws FoodSupplierException {
        try {
            begin();
            Query q = getSession().createQuery("from FoodSupplier");
            List<FoodSupplier> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new FoodSupplierException("Could not list the foodSuppliers", e);
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
			getSession().delete(fi);
			commit();
			System.out.println("Deleted Successfuuly from DAO method");
		} catch (HibernateException e) {
			rollback();
			throw new FoodSupplierException("Could not get foodItem " + foodItemID, e);
		}
	}
	
	
}
