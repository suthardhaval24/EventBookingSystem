package com.bookevent.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bookevent.app.pojo.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// basic validations
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "empty.first", "First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "empty.last", "Last Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username", "username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", "email is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "empty.confirmPassword", "confirm password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "empty.phonenumber", "phonenumber is Required");
	}

}
