package com.mystudent.hibernate.student.student_hibernate.hql;
import com.mystudent.hibernate.student.student_hibernate.utility.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import java.util.*;

public class RetrieveStdNameUsingHQL 
{
	public static void main(String[] args) 
	{
		// To create session reference
		Session session = StudentUtility.getSessionFactory().openSession();
		/*--- Creating query reference to retrieve name of all the students ---*/
		Query query = session.createQuery("select stdName from StudentEntities"); //Create query method using Query Interface
		/*---- To execute the query ----*/
		List<String> studentNames = query.list(); //List interface .list() method
		if(studentNames.size()>0)
		{
			System.out.println("----- Name of students ----");
			for (String stdname : studentNames) 
			{
				System.out.println(stdname);
			}
		}
		else
		{
			System.out.println("No data found");
		}
		/*--- To close SessionFactory -----*/
		StudentUtility.getSessionFactory().close();
	}
}
