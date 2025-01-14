package com.mystudent.hibernate.student.student_hibernate.dto;

import com.mystudent.hibernate.student.student_hibernate.utility.*;
import com.mystudent.hibernate.student.student_hibernate.entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.*;
public class FetchStudentIdAndNameAndAge 
{
	public static void main(String[] args) 
	{
		// creating session reference
		Session session= StudentUtility.getSessionFactory().openSession();
		/*--- creating query reference to fetch studentId,studentName and stdAge ---*/
		Query query = session.createQuery("select new com.mystudent.hibernate.student.student_hibernate.dto.StudentIdNameAgeDTO(stdId,stdName,stdAge) from StudentEntities");
		/*Here use select new currentPackage.DtoClass(parameters) from StudentEntityClass*/
		/*--- executing query ----*/
		List<StudentIdNameAgeDTO> stdlist=query.list();
		if(stdlist.size() > 0)
		{
			System.out.println("----- Student data -----");
			for (StudentIdNameAgeDTO studentIdNameAgeDTO : stdlist) 
			{
				System.out.println(studentIdNameAgeDTO);
			}
		}
		else
		{
			System.out.println("No record found");
		}
		/*---closing session factory ----*/
		StudentUtility.getSessionFactory().close();
	}

}

