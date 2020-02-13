package com.bookevent.app.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.bookevent.app.pojo.Events;

public class EventDAO extends DAO {

	public List<Events> getEvent() {
		List<Events> events = null;
		try {
			begin();
			Query query = getSession().createQuery("from Events");
			events = query.list();
			commit();
		} catch (Exception e) {
			rollback();
		} finally {
			getSession().close();
		}
		return events;
	}

	public Events getDetail(int id) {
		Events e = null;
		try {
			begin();
			Query query = getSession().createQuery("from Events where id =:eventid");
			query.setInteger("eventid", id);
			query.setMaxResults(1);
			e = (Events) query.uniqueResult();
			commit();
		} catch (Exception ex) {
			rollback();
		}
		return e;
	}

	public void updateEvent(int id, int seats) {
		try {
			begin();
			Query query = getSession().createQuery("Update Events SET avaibility = : avaibility where id =:eventid");
			query.setInteger("avaibility", seats);
			query.setInteger("eventid", id);
			query.executeUpdate();
			commit();
		} catch (Exception ex) {
			rollback();
		}
	}
}
