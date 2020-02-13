package com.bookevent.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookevent.app.dao.BookingDAO;
import com.bookevent.app.pojo.Booking;
import com.bookevent.app.pojo.User;

@Controller
public class HomeController {

	@Autowired
	BookingDAO bookingDao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") User user, Model model) {
		return "login";
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("user") User user, Model model, HttpSession session) {
		return "signup";
	}

	@RequestMapping(value = "/signout.htm", method = RequestMethod.GET)
	public String signOut(HttpSession session) {
		if (session.getAttribute("user") != null) {
			session.invalidate();
		}
		return "login";
	}

	@RequestMapping(value = "/bookings.htm", method = RequestMethod.GET)
	public String bookingDetails(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		User user = (User) session.getAttribute("user");
		long user_id = user.getUserID();
		List<Booking> booking = bookingDao.getDetails(user_id);
		session.setAttribute("booking", booking);
		return "booking_history";
	}
}
