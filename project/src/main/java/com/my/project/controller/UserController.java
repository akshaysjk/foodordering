package com.my.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.project.dao.FoodSupplierDAO;
import com.my.project.dao.UserDAO;
import com.my.project.exception.UserException;
import com.my.project.pojo.Address;
import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Menu;
import com.my.project.pojo.Person;
import com.my.project.pojo.User;
import com.my.project.validator.UserValidator;


@Controller
public class UserController {

	@Autowired
    @Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
    @Qualifier("foodSupplierDao")
	FoodSupplierDAO foodSupplierDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	protected String goToUserHome(HttpServletRequest request) throws Exception {
//		return "user-home";
//	}
	
	
	@RequestMapping(value = "customer/signup.htm", method = RequestMethod.GET)
	public String customerSignUp(@ModelAttribute User user,Model model)
	{
		System.out.println("Customer Signup Get method");
		return userCreate(user,model,true);
	}
	
	private String userCreate(User user,Model model,boolean init)
	{
		System.out.println("userCreate method--1");
		if(init)
		{
			AutoPopulatingList<Address> add= new	AutoPopulatingList<Address>(Address.class);
			add.add(new Address());
			System.out.println("userCreate method--2");
			user.setAddresses(add);
			
//			List<Address> addresses = Collections.synchronizedList(new ArrayList<Address>());
//			addresses.add(new Address());
//			user.setAddresses(addresses);
		}
		System.out.println("userCreate method--3");
		model.addAttribute("type","create");
		return "customerSignup";
	}
	
//	@RequestMapping(value = "customer/signup.htm", method = RequestMethod.GET)
//	public ModelAndView signup(HttpServletRequest request,HttpServletResponse response) throws IOException{
//
//		System.out.println("Signup");
//		String choice = request.getParameter("signupradio");
//	       if (choice.equalsIgnoreCase("user")){
//	           
//	        	   System.out.println("user");
//	        	   return new ModelAndView("customerSignup","user",new User());
//			
//	       }
//	       else if(choice.equalsIgnoreCase("foodSupplier")){
//	    	   
//	    	   System.out.println("foodsupplier");
//	    		   return new ModelAndView("foodsupplierSignup","foodSupplier",new FoodSupplier());
//				
//	       }
//	       
//	       System.out.println("Sign Up");
//		   return new ModelAndView("signup","results",null);
//	   }
	
	 
	
	
	
//	@RequestMapping(value = "/person/login", method = RequestMethod.POST)
//	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {
//
//		HttpSession session = (HttpSession) request.getSession();
//		
//		try {
//
//			System.out.println("loginUser2");
//			String usertype = request.getParameter("login");
//			if(usertype.equalsIgnoreCase("customer"))
//			{
//				
//			}
//
//			Person p = userDao.getPerson(request.getParameter("username"), request.getParameter("password"));
//			
//			if(usertype == null)
//			{
//				System.out.println("UserName/Password does not exist");
//				session.setAttribute("errorMessage", "UserName/Password does not exist");
//				return new ModelAndView("error", "errorMessage", "error while login");
//			}
//			
//			session.setAttribute("user", p);
//			
//			if(p.getPersonType().equalsIgnoreCase("admin"))
//			{
//				System.out.print("Admin Login");
//				return new ModelAndView("admin/admin-home", "user", p);
//			}
//			else if(p.getPersonType().equalsIgnoreCase("foodSupplier"))
//			{	
//				System.out.print("Food Supplier Login");
//				return new ModelAndView("foodSupplier/foodSupplier-home", "user", p);
//			}
//			return new ModelAndView("customer/user-home", "user", p);
//
//		} catch (UserException e) {
//			System.out.println("Exception: " + e.getMessage());
//			session.setAttribute("errorMessage", "error while login");
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
//
//	}
	
//	@RequestMapping(value = "/customersignup.htm", method = RequestMethod.GET)
//	protected String registerUser(Model model) throws Exception {
//		System.out.print("Customer Signup Get method");
//		model.addAttribute("user", new User());
//		return "user";
//
//	}
	
//	@RequestMapping(value = "/customersignup.htm", method = RequestMethod.POST)
//	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {
//System.out.println("Customer signup");
//		//validator.validate(user, result);
//
////		if (result.hasErrors()) {
////			return new ModelAndView("register-user", "user", user);
////		}
//
//		try {
//
//			System.out.println("registerNewUser");
//			System.out.println(user.getFirstName());
//			System.out.println(user.getAddresses().get(0).getArea());
//			User u = userDao.register(user);
//			
//			request.getSession().setAttribute("user", u);
//			
//			return new ModelAndView("user-home", "user", u);
//
//		} catch (UserException e) {
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
//	}
	
	 @RequestMapping(value = "/customersignup.htm", method = RequestMethod.POST)
	 protected ModelAndView registerNewUser(HttpServletRequest request,@ModelAttribute User user, BindingResult bindingResult, Model model) {
		 System.out.println("Customer Signup Post method--1");
		 validator.validate(user, bindingResult);   
		 if (bindingResult.hasErrors()) {
	            // Should not re-init the AutoPopulatingList
			 System.out.print("Customer Signup Post method--2");
	        	model.addAttribute("type","create");
	        	return new ModelAndView("customersignup", "user", user);
	        }
	        try{
			        // Call the private method
	        	System.out.println("Customer Signup Post method--3");
			        
			        // Persist the user
			        System.out.println("Customer Signup Post method--4");
			        User u = userDao.register(user);
			        System.out.println("Customer Signup Post method--5");
			        request.getSession().setAttribute("user", u);
					
			        return new ModelAndView("login", "user", u);
	        
	        	}
			        catch (UserException e) 
	        		{
						System.out.println("Exception: " + e.getMessage());
						return new ModelAndView("error", "errorMessage", "error while login");
			        }
	    }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.GET)
	    public String update(@PathVariable Integer pk, @ModelAttribute User user, Model model) {
	        // Add your own getEmployerById(pk)
		 System.out.println("Update Get method--1");
	        model.addAttribute("type", "update");
	        return "customerSignup";
	    }

	    @RequestMapping(value = "/update", method = RequestMethod.POST)
	    protected ModelAndView update(@PathVariable Integer pk, @ModelAttribute User user, BindingResult bindingResult, Model model) {
	        // Add your own getEmployerById(pk)
	    	System.out.println("Update Post method--0");
	        if (bindingResult.hasErrors()) {
	        	System.out.print("Update Post method--1");
	        	
	        	model.addAttribute("type", "update");
				return new ModelAndView("customerSignup", "user", user);
	        }
	        try{
	        	System.out.println("Update Post method--2");
	       // List<Address> addresses2remove = manageAddresses(user);
	        // First, save the employer
	        User u = userDao.register(user);
	        System.out.print("Update Post method--3");
	        return new ModelAndView("user-home", "user", u);
	        }
	        catch (UserException e) 
    		{
				System.out.println("Exception: " + e.getMessage());
				return new ModelAndView("error", "errorMessage", "error while login");
	        }
//	        employerService.update(employer);
//	        // Then, delete the previously linked employees which should be now removed
//	        for (Employee employee : employees2remove) {
//	            if (employee.getId() != null) {
//	                employeeService.delete(employee);
//	            }
//	        }
	        
	    }
	    
	    
	    @RequestMapping(value="/customer/viewRestaurants.htm", method = RequestMethod.GET)
		public ModelAndView viewRestaurants(HttpServletRequest request) throws Exception {		
			ModelAndView mv = new ModelAndView();
			System.out.println("Inside view Restaurants--1");
			List<FoodSupplier> list = foodSupplierDao.list();
			for(int i=0;i<list.size();i++)
			{
				System.out.println("Fname" +list.get(i).getFirstName());
				System.out.println("Lname" +list.get(i).getLastName());
				System.out.println("Phone" +list.get(i).getPhoneDetails());
				System.out.println("Card" +list.get(i).getCardDetails());
			}
			mv.addObject("foodSuppliers", list);
			System.out.println("Inside view Restaurants--2");
			HttpSession session = request.getSession();
			User user =(User)session.getAttribute("user");
			System.out.println("Inside view Restaurants--3");
			mv.addObject("user", user);
			System.out.println("Inside view Restaurants--4");
			mv.setViewName("viewRestaurants");
			return mv;
		}
	    
	    

}
