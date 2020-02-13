package com.bookevent.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.bookevent.app.pojo.User;

public class UserDAO extends DAO {

	public User create(User user) {
		try {
			begin();
			getSession().save(user);
			commit();
		} catch (Exception e) {
			rollback();
		}
		return user;
	}

	public void update(String fname, String lname, String phno) {
		try {
			begin();
			String firstname = "update user_info set fname =:fnmae where fname =:fname";
			String lastname = "update user_info set lname =:lnmae where lname =:lname";
			String phone = "update user_info set phonenumber =:phonenumber where phonenumber =:phonenumber";
			Query query = getSession().createQuery(firstname);
			Query query1 = getSession().createQuery(lastname);
			Query query3 = getSession().createQuery(phone);
			query.setString("fname", fname);
			query.executeUpdate();
			query1.setString("lname", lname);
			query1.executeUpdate();
			query3.setString("phonenumber", phno);
			query1.executeUpdate();
			commit();
			System.out.println("Done");
		} catch (Exception e) {
			rollback();
		}
	}

	public User authenticate(String uname, String pass) {
		User u = null;
		try {
			begin();
			Query query = getSession().createQuery("From User where username=:username and password=:password");
			query.setString("username", uname);
			query.setString("password", pass);
			query.setMaxResults(1);
			u = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			rollback();
		} finally {
			close();
		}
		return u;
	}

}
