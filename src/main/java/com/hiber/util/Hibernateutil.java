package com.hiber.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.hiber.Entity.Mobile;
import com.hiber.Entity.Person;

public class Hibernateutil {

	 private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            return new Configuration().configure().addAnnotatedClass(Mobile.class).addAnnotatedClass(Person.class).buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public static void shutdown() {
	        getSessionFactory().close();
	    }
	
	
}
