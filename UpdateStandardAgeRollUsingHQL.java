package com.mystudent.hibernate.student.student_hibernate.hql;
import com.mystudent.hibernate.student.student_hibernate.utility.*;

import org.hibernate.*;
import org.hibernate.query.Query;

import java.io.*;
public class UpdateStandardAgeRollUsingHQL 
{/*Retrieving data Dynamically as we use preparedStatement in JDBC*/
	public static void main(String[] args) throws IOException
	{
		// Creating object of BufferedReader class to receive input of data through keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Student id : ");
		String sid = br.readLine();
		System.out.print("Enter standard : ");
		String std = br.readLine();
		System.out.print("Enter roll number : ");
		int rollNo = Integer.parseInt(br.readLine());
		System.out.print("Enter Age(in year) : ");
		int age = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		/*-----------------------------------------------------------------------*/
		//Creating session reference
		Session session = StudentUtility.getSessionFactory().openSession();
		/*--- Creating reference of Transaction -------*/
		Transaction transaction = session.beginTransaction();
		//Creating reference of Query interface ----
	//	Query query = session.createQuery("update StudentEntities set stdStandard =: x, stdRoll =: y, stdAge =: z where stdId =: m"); //Using already defined query in entity class
		Query query = session.createNamedQuery("UpdateStandardAndRollAndAge");//Here we are using @NamedQuery(name="fetchStudentList) instead of query from entity class
		/*---- setting data into the parameter -----*/
		query.setParameter("x",std); //We need to set parameters for each argument
		query.setParameter("y", rollNo);
		query.setParameter("z",age);
		query.setParameter("m",sid);
		/*------------------------------------------------------------*/
		/*---- To execute update query -----*/
		int row = query.executeUpdate(); //ref.executeUpdate() method
		/*--- To commit changes into database ----*/
		transaction.commit();
		if(row > 0)
		{
			System.out.println("Data Successfully gets updated");
		}
		else
		{
			System.out.println("Unable to update data");
		}
		/*---- To close Session factory ------*/
		StudentUtility.getSessionFactory().close();
	}

}
