package com.my.project.exception;

public class FoodItemException extends Exception {

	public FoodItemException(String message)
	{
		super("FoodItemException-"+message);
	}
	
	public FoodItemException(String message, Throwable cause)
	{
		super("FoodItemException-"+message,cause);
	}
}