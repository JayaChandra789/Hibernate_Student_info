package com.mystudent.hibernate.student.student_hibernate.deletedata;

import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;
import org.hibernate.*;

public class DeleteData 
{
	public static void main(String[] args) 
	{
		// To create Session reference
		Session sessionRef = StudentUtility.getSessionFactory().openSession();
		// To retrieve student Record
		StudentEntities entityObj = sessionRef.get(StudentEntities.class, "std2");
		/*----Verifying student record exists*/
		if(entityObj == null)
		{
			System.out.println("No student record found to delete.");
		}
		else
		{
			/*------Record Found-----*/
			System.out.println("---------------------------------------");
			System.out.println("Record Found: " + entityObj);
			System.out.println("---------------------------------------");
			/*Creating reference for transaction*/
			Transaction transactionRef = sessionRef.beginTransaction();
			
			/*---------Delete METHOD--------*/
			sessionRef.delete(entityObj);
			/*------Commit Transaction------*/
			transactionRef.commit();
			/*--------------------------------------------------------------*/
			System.out.println("---------------------------------------");
			System.out.println("Student Data Deleted Succesfully.");
		}
		System.out.println("---------------------------------------");
		/*----Close Session-----*/
		sessionRef.close();
		/*----Close Session Factory-----*/
		StudentUtility.getSessionFactory().close();
	}
}
