package com.bookevent.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bookevent.app.pojo.Events;
import com.bookevent.app.pojo.User;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGeneration extends AbstractPdfView {

	Events events;
	User user;
	int seats;

	public PdfGeneration(Events events, User user, int seats) {
		this.events = events;
		this.user = user;
		this.seats = seats;
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user = "Hello,\n" + this.user.getFname() + " " + this.user.getLname() + ",";
		String subject = "Below is your booking information:";
		String greet = "Thanks for booking event with BookYourEvents.com!";
		String signature = "Team,\n" + "BookYourEvents";
		Element e1 = new Paragraph(user);
		Element e2 = new Paragraph(subject);
		Element e3 = new Paragraph("Event Name:" + "\t" + this.events.getEvent_name());
		Element e4 = new Paragraph("Event Place:" + "\t" + this.events.getAddress());
		Element e5 = new Paragraph("Price:" + "\t" + this.events.getPrice());
		Element e6 = new Paragraph("Total Seats: \t" + this.seats);
		Element e7 = new Paragraph("Total Price: \t" + this.events.getPrice() * this.seats);
		Element e8 = new Paragraph(greet);
		Element e9 = new Paragraph(signature);
		document.add(e1);
		document.add(e2);
		document.add(e3);
		document.add(e4);
		document.add(e5);
		document.add(e6);
		document.add(e7);
		document.add(e8);
		document.add(e9);

	}

}
