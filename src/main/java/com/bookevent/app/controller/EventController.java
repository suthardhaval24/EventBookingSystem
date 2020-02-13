package com.bookevent.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RespectBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookevent.app.dao.EventDAO;
import com.bookevent.app.pojo.Events;

@Controller
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventDAO eventDao;

	@RequestMapping(value = "/book.htm", method = RequestMethod.POST)
	public String bookTicket(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "login";
		}
		int id = Integer.parseInt(request.getParameter("eventID"));
		Events e = eventDao.getDetail(id);
		request.setAttribute("event_detail", e);
		return "booking";
	}
}
