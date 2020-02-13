package com.bookevent.app.controller;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookevent.app.dao.UserDAO;
import com.bookevent.app.pojo.Events;
import com.bookevent.app.pojo.User;
import com.bookevent.app.validator.UserValidator;

@Controller
public class SingUpController {

	private static final Logger logger = LoggerFactory.getLogger(SingUpController.class);

	@Autowired
	UserDAO userDao;

	@Autowired
	UserValidator uservalidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	@RequestMapping(value = "/user_signup.htm", method = RequestMethod.POST)
	public String userSignUp(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "signup"; // the are validation errors, go to the form view
		}
		userDao.create(user);
		try {
			sendConfirmationMail(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}
	
	
	private void sendConfirmationMail(User user) throws EmailException {
		Email email = new SimpleEmail();
		//email.setDebug(true);
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("bookyourevents227@gmail.com", "bookyourevents1234"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply_bookyourevents@gmail.com");
		email.setSubject("Hello from BookYourEvent");
		email.setMsg("Hello" + user.getFname() + " " + user.getLname() + "!\n" + "Welcome to BookYourEvents!\n"
				+ "We are sure that we will make your event booking convient and hassle free!\n"
				+ "Keep calm and book your tickets\n" + "From,\n" + "Team:BookyourEvents");
		email.addTo(user.getEmail());
		email.send();
	}

}
