package com.my.project.exception;

public class FoodSupplierException extends Exception {

	

		public FoodSupplierException(String message)
		{
			super("FoodSupplierException-"+message);
		}
		
		public FoodSupplierException(String message, Throwable cause)
		{
			super("FoodSupplierException-"+message,cause);
		}
}
