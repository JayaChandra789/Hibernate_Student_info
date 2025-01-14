package com.mystudent.hibernate.student.student_hibernate.update;
import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;
import org.hibernate.*;

public class StudentIdAndAgeUpdate 
{
	public static void main(String[] args) 
	{
		// To create Session reference
		Session sessionRef = StudentUtility.getSessionFactory().openSession();
		// To retrieve student Record
		StudentEntities entityObj = sessionRef.get(StudentEntities.class, "std1");
		/*----Verifying student record exists*/
		if(entityObj == null)
		{
			System.out.println("No student record found.");
		}
		else
		{
			/*------Record Found-----*/
			System.out.println("---------------------------------------");
			System.out.println("Record Found: " + entityObj);
			System.out.println("---------------------------------------");
			/*Creating reference for transaction*/
			Transaction transactionRef = sessionRef.beginTransaction();
			/*--To set new Standard--*/
			entityObj.setStdStandard("14th");
			/*--To set new Age--*/
			entityObj.setStdAge(20);
			/*---------UPDATE METHOD--------*/
			sessionRef.update(entityObj);
			/*------Commit Transaction------*/
			transactionRef.commit();
			/*--------------------------------------------------------------*/
			System.out.println("---------------------------------------");
			System.out.println("Student Data Updated Succesfully.");
		}
		System.out.println("Updated Record: " + entityObj);
		System.out.println("---------------------------------------");
		/*----Close Session-----*/
		StudentUtility.getSessionFactory().close();
		sessionRef.close();
	}
}
