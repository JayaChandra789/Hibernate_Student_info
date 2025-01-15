package com.mystudent.hibernate.student.student_hibernate.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cache.jcache.internal.JCacheRegionFactory;
import org.hibernate.query.Query;

import com.mystudent.hibernate.student.student_hibernate.entities.StudentEntities;
import com.mystudent.hibernate.student.student_hibernate.utility.StudentUtility;

public class RetreiveProductDetailsUsingHQL 
{
	public static void main(String[] args) 
	{
		//JCacheRegionFactory
		// To create Session reference
		Session sessionRef = StudentUtility.getSessionFactory().openSession();
		// To Retrieve Product by using ID
		Product product = sessionRef.get(Product.class, "product2");
		//get() method is SLOW when compared with load() as it need to fire query as when it wants to retrieve data from DB
		//To check data is retrieved or not?
		System.out.println("------------------------------------------");
		if(product == null)
		{
			System.out.println("No any Product Exists with id Product1000");
		}
		else
		{
			System.out.println(product);
		}
		System.out.println("------------------------------------------");
		
		System.out.println("----------Second Session Object----------");
		// Creating another Session reference for same DATA 
		Session sessionRef2 = StudentUtility.getSessionFactory().openSession();
		// To Retrieve Product by using ID
		Product product2 = sessionRef2.get(Product.class, "product2");
		//get() method is SLOW when compared with load() as it need to fire query as when it wants to retrieve data from DB
		//To check data is retrieved or not?
		if(product2 == null)
		{
			System.out.println("No any Product Exists with id Product1000");
		}
		else
		{
			System.out.println(product2);
		}
		/*-----------To close session factory----------*/
		StudentUtility.getSessionFactory().close();
	}
}
