package com.mystudent.hibernate.student.student_hibernate.product;
import org.hibernate.*;

import com.mystudent.hibernate.student.student_hibernate.utility.StudentUtility;
public class ProductUpdate 
{
	public static void main(String[] args) 
	{
		// To create Session reference
		Session sessionRef = StudentUtility.getSessionFactory().openSession();
		// To retrieve student Record
		Product entityObj = sessionRef.get(Product.class, "product1");
		/*----Verifying student record exists*/
		if(entityObj == null)
		{
			System.out.println("No  record found.");
		}
		else
		{
			/*------Record Found-----*/
			System.out.println("---------------------------------------");
			System.out.println("Record Found: " + entityObj);
			System.out.println("---------------------------------------");
			/*Creating reference for transaction*/
			Transaction transactionRef = sessionRef.beginTransaction();

			// Update fields 
			entityObj.setName("Sharpner");
			entityObj.setPrice(5.5f);
			entityObj.setQuantity(2);

			/*---------UPDATE METHOD--------*/
			sessionRef.update(entityObj);
			/*------Commit Transaction------*/
			transactionRef.commit();
			/*--------------------------------------------------------------*/
			System.out.println("---------------------------------------");
			System.out.println(" Data Updated Succesfully.");
		}
		System.out.println("Updated Record: " + entityObj);
		System.out.println("---------------------------------------");
		/*----Close Session-----*/
		StudentUtility.getSessionFactory().close();
		sessionRef.close();
	}
}
