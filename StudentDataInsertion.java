package com.mystudent.hibernate.student.student_hibernate.insertstudent;
import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDataInsertion 
{
	public static void main (String[] jaya)
	{
		// Creating session from Sesion Factory
		Session sessionRef = StudentUtility.getSessionFactory().openSession(); //Using Student utility class
		
		//Creating Transaction Reference
		Transaction transactionRef = sessionRef.beginTransaction();
		
		//Creating object for Entities
		StudentEntities student1  = new StudentEntities("std1","Jaya",22,185,"16th","HYD"); //still in Transient state not commited
		
		/*----Inserting Entities into data base----*/
		sessionRef.save(student1); //Commit changes in data base from transient state
		//commit the changes in data base
		transactionRef.commit(); //Now student 1 in persistent state
	}
}
