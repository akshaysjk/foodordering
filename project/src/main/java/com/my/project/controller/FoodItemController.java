package com.my.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.project.dao.CartDAO;
import com.my.project.dao.FoodItemDAO;
import com.my.project.pojo.FoodItem;
import com.my.project.pojo.FoodSupplier;
import com.my.project.pojo.Menu;
import com.my.project.pojo.User;
import com.my.project.validator.FoodItemValidator;



@Controller
public class FoodItemController {

	
	@Autowired
    @Qualifier("foodItemDao")
	FoodItemDAO foodItemDao;
	
	@Autowired
    @Qualifier("cartDao")
	CartDAO cartDao;
	
	@Autowired
	@Qualifier("foodItemValidator")
	FoodItemValidator validator;
	
	@RequestMapping(value = "/foodSupplier/updateFoodItem.htm",method= RequestMethod.GET)
	public ModelAndView updateFoodItemPage(HttpServletRequest request) throws Exception
    {
    	String id = request.getParameter("id");
    	FoodItem fi = foodItemDao.getFoodItem(Integer.parseInt(id));
    	ModelAndView mv = new ModelAndView();
    	
    	mv.addObject("foodItem",fi);
    	
		
		System.out.println("Inside updateFoodItem--3");
		
		mv.setViewName("updateFoodItem");
		return mv;
    }
	
	@RequestMapping(value = "/foodSupplier/UpdateAndDeleteFoodItemPage.htm",method= RequestMethod.GET)
	public ModelAndView updateandDeleteFoodItemPagefromSuccess(HttpServletRequest request) throws Exception
    {
		HttpSession session = request.getSession();
		FoodSupplier fs =(FoodSupplier)session.getAttribute("foodSupplier");
		Menu menu = fs.getMenu();
		long menuId = menu.getId();
		System.out.println("Menu Id"+menuId);
		List<FoodItem> foodItems = foodItemDao.getFoodItems(menuId);
		System.out.println("Redirecting to Update Delete FoodItems Page");
		long id = fs.getPersonID();
		System.out.println("Id"+id);
		return  new ModelAndView("updateDeleteFoodItem","foodItems",foodItems);
    }
	
	
	@RequestMapping(value = "/foodSupplier/UpdateAndDeleteFoodItemPage.htm",method= RequestMethod.POST)
	public ModelAndView updateandDeleteFoodItemPage(HttpServletRequest request) throws Exception
    {
		HttpSession session = request.getSession();
		FoodSupplier fs =(FoodSupplier)session.getAttribute("foodSupplier");
		Menu menu = fs.getMenu();
		long menuId = menu.getId();
		System.out.println("Menu Id"+menuId);
		List<FoodItem> foodItems = foodItemDao.getFoodItems(menuId);
		System.out.println("Redirecting to Update Delete FoodItems Page");
		long id = fs.getPersonID();
		System.out.println("Id"+id);
		return  new ModelAndView("updateDeleteFoodItem","foodItems",foodItems);
    }
	
	@RequestMapping(value = "/foodSupplier/UpdateFoodItemPage.htm", method = RequestMethod.POST)
	public ModelAndView updateFoodItem(HttpServletRequest request) throws Exception
	{
		System.out.println("Inside Update the single food item method");
		long id = Long.parseLong(request.getParameter("foodItem"));
		String foodItemName = request.getParameter("fooditemname");
		long price =Long.parseLong(request.getParameter("price"));
		String description = request.getParameter("description");
		System.out.println("Id "+id+"description"+description+"foodItemName"+foodItemName+"Price"+price);
		foodItemDao.updateFoodItem(id, foodItemName, description, price);
		System.out.println("Updated Food Item successfully");
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("updateSuccess");
    	return mv;
	}
	

	@RequestMapping(value = "foodSupplier/deleteFoodItem.htm", method = RequestMethod.GET)   
	public 	@ResponseBody
	String deleteFoodItem(HttpServletRequest request) throws Exception
    {
		System.out.println("Called from Ajax delete foodItem function");
		String foodItemId =request.getParameter("id");
		foodItemDao.deleteFoodItem(Integer.parseInt(foodItemId));
		return foodItemId;
    }
	
	@RequestMapping(value ="/customer/addToCart.htm" ,method = RequestMethod.GET)
	public @ResponseBody
	String addToCart(HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("user");
		System.out.println("Called from Ajax delete foodItem function");
		String foodItemId =request.getParameter("id");
		FoodItem foodItem = foodItemDao.getFoodItem(Integer.parseInt(foodItemId));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cartDao.addEntry(user,foodItem,quantity);
		return "ID"+foodItemId+"Quantity"+quantity;
		
	}
	
}
