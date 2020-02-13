package com.bookevent.app.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.bookevent.app.pojo.Booking;

public class BookingDAO extends DAO {

	public Booking create(Booking booking) {
		try {
			begin();
			getSession().save(booking);
			commit();
		} catch (Exception e) {
			rollback();
		}
		return booking;
	}

	public List<Booking> getDetails(long id) {
		List<Booking> booking = null;
		try {
			begin();
			Query query = getSession().createQuery("from Booking where user_userID = :userID");
			query.setLong("userID",id);
			booking = query.list();
			commit();
		} catch (Exception e) {
			rollback();
		} finally {
			getSession().close();
		}
		return booking;
	}
}
