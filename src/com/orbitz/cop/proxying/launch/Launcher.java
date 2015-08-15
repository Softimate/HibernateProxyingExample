package com.orbitz.cop.proxying.launch;

import org.hibernate.Session;

import com.orbitz.cop.proxying.hibernate.HibernateSessionFactory;
import com.orbitz.cop.proxying.hibernate.User;

public class Launcher {

	public static void main(String[] args) {

		Session session = HibernateSessionFactory.getSession();
		
		User user = (User) session.get(User.class, 1);
		session.close();
		System.out.println("ID=" + user.getId());
		System.out.println("Address size=" + user.getAddresseses().size());
		
		
	}

}
