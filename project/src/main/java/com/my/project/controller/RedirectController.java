package com.my.project.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.my.project.pojo.User;
import com.my.project.dao.AdminDAO;
import com.my.project.dao.FoodSupplierDAO;
import com.my.project.dao.UserDAO;
import com.my.project.exception.UserException;
import com.my.project.pojo.Address;
import com.my.project.pojo.Admin;
import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Person;





@Controller
public class RedirectController extends MyController {
	
	@Autowired
    @Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
    @Qualifier("foodSupplierDao")
	FoodSupplierDAO foodSupplierDao;
	
	@Autowired
    @Qualifier("adminDao")
	AdminDAO adminDao;
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public static String loginPage(HttpServletRequest request,HttpServletResponse response)
	{
		 
      	   System.out.println("login");
			return "login"; 
		
	}
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public static String signUpPage(HttpServletRequest request,HttpServletResponse response)
	{
		 
      	   System.out.println("signUp");
			return "signup";
		
	}
	
	
	@RequestMapping(value = "/user.htm", method = RequestMethod.POST)
	public void showPage(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("InRedirectController");
		String choice = request.getParameter("useraction");
	       if (choice.equalsIgnoreCase("login")){
	           try {
	        	   System.out.println("login");
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	       else if(choice.equalsIgnoreCase("signup")){
	    	   
	    	   try {
	    		   System.out.println("signUp");
					response.sendRedirect("signup.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       }
	}
	
	@RequestMapping(value = "/person/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {

			System.out.println("loginUser2");
			String usertype = request.getParameter("login");
			
			if(usertype == null)
			{
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error", "errorMessage", "error while login");
			}
			
			if(usertype.equalsIgnoreCase("customer"))
			{
				User u = userDao.get(request.getParameter("username"), request.getParameter("password"));
				session.setAttribute("user", u);
				return new ModelAndView("user-home", "user", u);
			}
			else if(usertype.equalsIgnoreCase("foodSupplier"))
			{
				System.out.println("FoodSupplier");
				FoodSupplier fs = foodSupplierDao.get(request.getParameter("username"), request.getParameter("password"));
				System.out.println("UserName"+fs.getUsername());
				session.setAttribute("foodSupplier",fs );
				return new ModelAndView("foodSupplier-home", "foodSupplier", fs);
			}
			else if(usertype.equalsIgnoreCase("admin"))
			{
				Admin admin = adminDao.get(request.getParameter("username"), request.getParameter("password"));
				session.setAttribute("admin",admin );
				return new ModelAndView("admin-home", "admin",admin);
			}
			
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error", "errorMessage", "error while login");


		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		   try{
//		   String keyword=request.getParameter("searchcriteria");
//		   System.out.println(keyword);	
//		   String userType=request.getParameter("loginradio");
//		   Session hibernatesession = getSession();
//		   Query hqlquery = null;
//		   if (userType.equalsIgnoreCase("user")){
//			   hqlquery = hibernatesession.createQuery("from User where userna like '%"+keyword+"%'"); 
//			   }else if (userType.equalsIgnoreCase("admin")){
//				   hqlquery = hibernatesession.createQuery("from Admin where actor like '%"+keyword+"%'"); 
//			   }
//			   else{
//				   hqlquery = hibernatesession.createQuery("from FoodSupplier where actress like '%"+keyword+"%'"); 
//			   }
//
//			List<Movie> results = hqlquery.list();
//			hibernatesession.close();
//			request.setAttribute("keyword", keyword);
//			request.setAttribute("results",results);
//		    return new ModelAndView("SearchResults","results",results);
//		   }
//		   catch(Exception e)
//		   {
//			   response.sendRedirect("BrowseMovies.jsp");
//		   }
		System.out.println("Login Htm");
		   return new ModelAndView("login","results",null);
	   }
	
	
	

}
