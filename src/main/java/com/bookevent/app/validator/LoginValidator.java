package com.bookevent.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bookevent.app.pojo.User;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty.username", "username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "password is Required");
	}

}
