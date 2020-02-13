package com.bookevent.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bookevent.app.pojo.Booking;
import com.bookevent.app.pojo.User;

public class BookingValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "no_of_tickets", "empty.no_of_tickets", "number of tickets is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card_detail", "empty.card_detail", "card_detail is Required");
	}

}
