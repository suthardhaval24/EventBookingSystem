package com.bookevent.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookevent.app.dao.UserDAO;
import com.bookevent.app.pojo.User;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDAO userDao;

	@RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
	public String userInfo(@ModelAttribute("user") User user, HttpSession session) {
		return "userprofile";
	}

	@RequestMapping(value = "/profileUpdate.htm", method = RequestMethod.POST)
	public String updateInfo(HttpServletRequest req, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		String fname;
		String lname;
		String phno;
		User u = (User) session.getAttribute("user");
		if (!req.getParameter("fname").isEmpty()) {
			fname = req.getParameter("fname");
		} else {
			fname = u.getFname();
		}

		if (!req.getParameter("lname").isEmpty()) {
			lname = req.getParameter("lname");
		} else {
			lname = u.getLname();
		}

		if (!req.getParameter("phonenumber").isEmpty()) {
			phno = req.getParameter("phonenumber");
		} else {
			phno = u.getPhonenumber();
		}
		userDao.update(fname, lname, phno);
		return "userprofile";
	}
}
