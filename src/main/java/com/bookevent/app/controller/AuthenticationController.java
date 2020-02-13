package com.bookevent.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookevent.app.dao.EventDAO;
import com.bookevent.app.dao.UserDAO;
import com.bookevent.app.pojo.Events;
import com.bookevent.app.pojo.User;
import com.bookevent.app.validator.LoginValidator;
import com.bookevent.app.validator.UserValidator;

@Controller
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	UserDAO userDao;

	@Autowired
	EventDAO eventDao;

	@Autowired
	LoginValidator loginValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}

	@RequestMapping(value = "/eventpage.htm", method = RequestMethod.POST)
	public String loginAuthentication(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
			ModelMap model,
			HttpServletRequest request, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "login"; // the are validation errors, go to the form view
		}

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		User u = userDao.authenticate(uname, pass);
		if (u == null) {
			return "login_error";
		} else {
			session.setAttribute("user", u);
			List<Events> events = eventDao.getEvent();
			session.setAttribute("event", events);
			return "mainpage";
		}

	}
}