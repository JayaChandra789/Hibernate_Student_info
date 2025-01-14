package com.mystudent.hibernate.student.student_hibernate.insertstudent;
import com.mystudent.hibernate.student.student_hibernate.coursefk.CourseDetailsEntities;
import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDataInsertion 
{
	public static void main (String[] jaya)
	{
		// Creating session from Session Factory
		Session sessionRef = StudentUtility.getSessionFactory().openSession(); //Using Student utility class
		
		//Creating Transaction Reference
		Transaction transactionRef = sessionRef.beginTransaction();
		
		//Creating object for Entities
		CourseDetailsEntities course1 = new CourseDetailsEntities("course101","Full Stack python","APJ",4);
		CourseDetailsEntities course2 = new CourseDetailsEntities("course102","Full Stack java","API",5);
		//First check relation mentioned in entities
		//Creating object for Entities
	//	StudentEntities student1  = new StudentEntities("std1","Jaya",22,185,"16th","HYD",course1); //still in Transient state not committed
	//	StudentEntities student2  = new StudentEntities("std2","Vijay",18,2,"13th","khmm",course1);
		StudentEntities student3  = new StudentEntities("std5","Nithin",18,135,"15th","YSFGD",course1);
		StudentEntities student4  = new StudentEntities("std6","Vinayak",21,111,"15th","SRCLA",course2);
		
		/*----Inserting Entities into data base----*/
		sessionRef.save(course1);
		sessionRef.save(course2);
		/*----Inserting Entities into data base----*/
//		sessionRef.save(student1); //Commit changes in data base from transient state
		sessionRef.save(student3);
		sessionRef.save(student4); 
		
		//commit the changes in data base
		transactionRef.commit(); //Now student 1 in persistent state
		System.out.println("Data Inserted succesfully");
		
		StudentUtility.getSessionFactory().close();
	}
}
