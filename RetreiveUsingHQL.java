package com.mystudent.hibernate.student.student_hibernate.hql;

import com.mystudent.hibernate.student.student_hibernate.entities.*;
import com.mystudent.hibernate.student.student_hibernate.utility.*;

import org.hibernate.*;
import org.hibernate.query.*;

import java.util.*;

public class RetreiveUsingHQL 
{
	public static void main(String[] args) 
	{
		/*-------Creating Session------*/
		Session session = StudentUtility.getSessionFactory().openSession();
		/*-------Creating reference of Query interface to retrieve student data-------*/
		Query queryRef = session.createQuery("from student");
		/*----------------------Executing the query---------------------*/
		List<StudentEntities> studentList = queryRef.list();
		/*----------Checking data------------*/
		if(studentList.size() > 0)
		{
			/*-------Student record found-------*/
			System.out.println("---------Record found.--------");
			System.out.println("---------Student Details--------");
			for(StudentEntities student : studentList)
			{
				System.out.println(student);
			}
			System.out.println("---------------------------------");
		}
		else
		{
			System.out.println("No record Found.");
		}
		/*--------Close the session---------*/
		StudentUtility.getSessionFactory().close();
	}
}
