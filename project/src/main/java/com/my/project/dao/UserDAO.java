package com.my.project.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.project.dao.DAO;
import com.my.project.exception.UserException;
import com.my.project.pojo.Address;
import com.my.project.pojo.Email;
import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Person;
import com.my.project.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public Person getPerson(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			Person person = (Person) q.uniqueResult();
			commit();
			close();
			return person;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where personID= :personID");
			q.setInteger("personID", userId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}
	
	private List<Address> manageAddresses(User u,User user) {
        // Store the employees which shouldn't be persisted
	 System.out.println("manageAddresses method--1");
        List<Address> addresses2remove = new ArrayList<Address>();
        
        if (u.getAddresses() != null) {
        	System.out.println("manageAddresses method--2");
        	
            for (Iterator<Address> i = u.getAddresses().iterator(); i.hasNext();) {
            	System.out.println("manageAddresses method--3");
            		
            	Address address = new Address();
            	address = i.next();
            	System.out.println("Area "+address.getArea());
            	System.out.println("Ad "+address.getCity());
            	System.out.println("Address "+address.getState());
                // If the remove flag is true, remove the address from the list
//                if (address.getRemove() == 1) {
//                	System.out.println("manageAddresses method--4");
//                	addresses2remove.add(address);
//                    i.remove();
//                // Otherwise, perform the links
//                } else {
            	
                	System.out.println("manageAddresses method--5");
                    address.setUser(user);
                    
                    
               // }
            }
        }
        return addresses2remove;
    }

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside user DAO");
			
			System.out.println("After manageAddresses method--1");
			Email email = new Email(u.getEmail().getEmailAddress());
			System.out.println("After manageAddresses method--2");
			User user = new User(u.getUsername(), u.getPassword(),"customer");
			manageAddresses(u,user);
			System.out.println("After manageAddresses method--3");
            System.out.println(u.getFirstName());
            System.out.println("After manageAddresses method--4");
			user.setFirstName(u.getFirstName());
			System.out.println("After manageAddresses method--5");
			user.setLastName(u.getLastName());
			System.out.println("After manageAddresses method--6");
			user.setEmail(email);
			System.out.println("After manageAddresses method--7");
			email.setUser(user);
			user.setAddresses(u.getAddresses());
			System.out.println("After manageAddresses method--8");
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}
}
