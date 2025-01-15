package com.mystudent.hibernate.student.student_hibernate.product;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mystudent.hibernate.student.student_hibernate.utility.StudentUtility;

public class ProductInsert 
{
	public static void main(String[] args) 
	{

		// Creating session from Session Factory
		Session sessionRef = StudentUtility.getSessionFactory().openSession(); 
		
		//Creating Transaction Reference
		Transaction transactionRef = sessionRef.beginTransaction();
		
		Product productObj = new Product("product1","Pen",10.5f,5);
		Product productObj2 = new Product("product2","Pencil",11.5f,2);
		Product productObj3 = new Product("product3","Eraser",22.5f,10);
		Product productObj4 = new Product("product4","Pad",30.5f,3);
		/*Save method to save object of product entity class which in transient state*/
		sessionRef.save(productObj);
		sessionRef.save(productObj2); 
		sessionRef.save(productObj3); 
		sessionRef.save(productObj4); 
		
		//commit the changes in data base
		transactionRef.commit(); 
		System.out.println("Data Inserted succesfully");
		//
		StudentUtility.getSessionFactory().close();
	}

}
