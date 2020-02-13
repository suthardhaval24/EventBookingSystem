package com.bookevent.app.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.bookevent.app.dao.BookingDAO;
import com.bookevent.app.dao.EventDAO;
import com.bookevent.app.pojo.Booking;
import com.bookevent.app.pojo.Events;
import com.bookevent.app.pojo.User;

@Controller
public class ReportController {

	@Autowired
	EventDAO eventDao;
	
	@Autowired
	BookingDAO bookingDao;

	@RequestMapping(value = "/report.pdf", method = RequestMethod.POST)
	public View getReport(@ModelAttribute("booking") Booking booking,HttpServletRequest request, HttpSession session) {
			
		int id = Integer.parseInt(request.getParameter("eventID"));
		int seats = Integer.parseInt(request.getParameter("no_of_tickets"));
		Events event = eventDao.getDetail(id);
		int total = event.getAvaibility();
		int remaining = total - seats;
		eventDao.updateEvent(id, remaining);
		User user = (User) session.getAttribute("user");
		booking.setUser(user);
		booking.setEvent(event);
		booking.setBook_date(new Date());
		booking.setTotal_amount(seats*event.getPrice());
		Booking b = bookingDao.create(booking);
		//storing booking data
		View view = new PdfGeneration(event, user, seats);
		try {
			sendBookingMail(event, user, seats);
		} catch (Exception e) {
			System.out.println(e);
		}
		return view;
	}

	private void sendBookingMail(Events event, User user, int seats) throws EmailException {
		Email email = new SimpleEmail();
		// email.setDebug(true);
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("bookyourevents227@gmail.com", "bookyourevents1234"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply_bookyourevents@gmail.com");
		email.setSubject("Order Confirmation");
		email.setMsg("Hello,\n" + user.getFname() + " " + user.getLname() + "!\n" + "Below is your order details:\n"
				+ "Event Name: " + event.getEvent_name() + "\n" + "Event Location: " + event.getAddress() + "\n"
				+ "Event City: " + event.getCity() + "\n" + "Total Seats: " + seats + "\n" + "Total Price: $"
				+ event.getPrice() * seats + "\n" + "From,\n" + "Team:BookyourEvents");
		email.addTo(user.getEmail());
		email.send();
	}
}
