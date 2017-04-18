package com.my.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.project.dao.FoodSupplierDAO;

import com.my.project.exception.FoodSupplierException;

import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Menu;
import com.my.project.validator.FoodSupplierValidator;


@Controller
public class FoodSupplierController {

	
	@Autowired
    @Qualifier("foodSupplierDao")
	FoodSupplierDAO foodSupplierDao;

	@Autowired
	@Qualifier("foodSupplierValidator")
	FoodSupplierValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "foodSupplier/signup.htm", method = RequestMethod.GET)
	protected ModelAndView foodSupplierSignup(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new ModelAndView("foodsupplierSignup","foodSupplier",new FoodSupplier());
	}
	
	@RequestMapping(value = "/foodsupplierUpdateMenu.htm", method = RequestMethod.POST)
	protected ModelAndView foodSupplierUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception 
	{
		HttpSession session = (HttpSession) request.getSession();
		try {
			String id = request.getParameter("foodSupplier");
			System.out.println(id);
			String fooditemname[] = request.getParameterValues("fooditemname");
			String description[] = request.getParameterValues("description");
			String price[] = request.getParameterValues("price");
			String foodType[] = request.getParameterValues("foodtype");
			
			FoodSupplier fs = foodSupplierDao.updateMenu((Integer.parseInt(id)),foodType,fooditemname,description,price); 

			System.out.print("loginUser");

			
			
			if(fs == null){
				
				return new ModelAndView("error", "errorMessage", "error while login");
			}
			
			session.setAttribute("foodSupplier", fs);
			
			return new ModelAndView("foodSupplierUpdateMenu","foodSupplier",fs);

		} catch (FoodSupplierException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
		
	}
	
	@RequestMapping(value = "/foodSupplier/login", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {

			System.out.print("loginUser");

			FoodSupplier u = foodSupplierDao.get(request.getParameter("username"), request.getParameter("password"));
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}
			
			session.setAttribute("foodSupplier", u);
			
			return "user-home";

		} catch (FoodSupplierException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}
	
	@RequestMapping(value = "/foodsupplierSignup.htm", method = RequestMethod.GET)
	protected String registerUser(Model model) throws Exception {
		System.out.print("registerUser");
		model.addAttribute("foodsupplier", new FoodSupplier());
		return "foodsupplier";

	}
	
	@RequestMapping(value = "/foodsupplierSignup.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("foodsupplier") FoodSupplier foodSupplier, BindingResult result) throws Exception {
System.out.println("Food Supplier signup");
		//validator.validate(user, result);

//		if (result.hasErrors()) {
//			return new ModelAndView("register-user", "user", user);
//		}

		try {

			System.out.println("registerNewFoodSupplier");
			System.out.println(foodSupplier.getFirstName());
		//	System.out.println(foodSupplier.getAddresses().get(0).getArea());
			FoodSupplier fs = foodSupplierDao.register(foodSupplier);
			
			request.getSession().setAttribute("user", fs);
			
			return new ModelAndView("login", "foodSupplier", fs);

		} catch (FoodSupplierException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	
	@RequestMapping (value= "/foodSupplier/UpdateMenu.htm" , method = RequestMethod.GET)
	protected ModelAndView updateMenu(HttpServletRequest request)
	{
		System.out.println("Redirecting to Update Menu");
		String id = request.getParameter("foodSupplier");
		System.out.println("Id--"+id);
		return  new ModelAndView("foodSupplierUpdateMenu","foodSupplier",id);
	}
	
	@RequestMapping (value= "/foodSupplier/viewMenu.htm" , method = RequestMethod.GET)
	protected ModelAndView viewMenu(HttpServletRequest request) throws FoodSupplierException
	{
		HttpSession session = request.getSession();
		FoodSupplier fs =(FoodSupplier)session.getAttribute("foodSupplier");
		System.out.println("Redirecting to View Menu");
		long id = fs.getPersonID();
		System.out.println("Id"+id);
		return  new ModelAndView("foodSupplierViewMenu","foodSupplier",fs);
	}

}
