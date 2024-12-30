package com.mystudent.hibernate.student.student_hibernate.retrieve;
import org.hibernate.Session;

import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;

public class StudentDataRetreiveByGetMethod 
{
	public static void main(String[] args) 
	{
		Session sessionRef = StudentUtility.getSessionFactory().openSession();
		// To Retrieve student by using ID
		StudentEntities student1 = sessionRef.get(StudentEntities.class, "std1");
		//To check data is retrieved or not?
		if(student1 == null)
		{
			System.out.println("No any student Exists with id std1");
		}
		else
		{
			System.out.println(student1);
		}
		/*-----------To close session factory----------*/
		StudentUtility.getSessionFactory().close();
	}
}
