package com.my.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.project.exception.UserException;
import com.my.project.pojo.Admin;
import com.my.project.pojo.Email;
import com.my.project.pojo.User;

public class AdminDAO extends DAO {
	
	public AdminDAO() {
	}
	
	public Admin get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Admin where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			Admin admin = (Admin) q.uniqueResult();
			commit();
			close();
			return admin;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public Admin get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Admin where personID= :personID");
			q.setInteger("personID", userId);		
			Admin admin = (Admin) q.uniqueResult();
			commit();
			return admin;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}
	
	
}
