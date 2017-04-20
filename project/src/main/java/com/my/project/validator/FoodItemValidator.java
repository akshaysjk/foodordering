package com.my.project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.my.project.pojo.FoodItem;



public class FoodItemValidator implements Validator {

		public boolean supports(Class aClass) {
			return aClass.equals(FoodItem.class);
		}

		public void validate(Object obj, Errors errors) {
			FoodItem foodItem = (FoodItem) obj;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.foodSupplier", "First Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.foodSupplier", "Last Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.foodSupplier", "FoodSupplier Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
					"Email Required");
			
			// check if user exists
			
		}

}
