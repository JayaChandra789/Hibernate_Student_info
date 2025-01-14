package com.mystudent.hibernate.student.student_hibernate.utility;

import org.hibernate.cfg.Configuration; //


import org.hibernate.SessionFactory; //
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StudentUtility 
{
	private static SessionFactory sessionfactoryRef;

	static
	{
		try
		{
			/*----Creating object of configuration class----*/
			Configuration configRef = new Configuration();
			/*----Setting the properties related to data base connection ----*/
			configRef.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			/*----SETTING URL OF DATA BASE----*/
			configRef.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydatabase");
			/*----Setting user name of data base----*/
			configRef.setProperty("hibernate.connection.username","root");
			/*----Setting password of data base----*/
			configRef.setProperty("hibernate.connection.password","Jaya@123");
			/*----Setting properties to configure logging for SQL statements----*/
			/*----Property to show SQL----*/
			configRef.setProperty("hibernate.show_sql",true);
			/*----Property to show well formatted----*/
			configRef.setProperty("hibernate.format_sql",true);
			/*----Setting Property for schema generation----*/
			configRef.setProperty("hibernate.hbm2ddl.auto","update"); //DDL commands
			/*------------------------------------------------------------------------*/
			/*---- setting annotated entity class----*/
			configRef.addAnnotatedClass(com.mystudent.hibernate.student.student_hibernate.entities.StudentEntities.class);
			configRef.addAnnotatedClass(com.mystudent.hibernate.student.student_hibernate.coursefk.CourseDetailsEntities.class);
			/*-------------------------------------------------------------------------------*/
			/*------------Creating reference of StandardRegistery to apply the settings---------------*/
			StandardServiceRegistry serviceRegistryRef = new StandardServiceRegistryBuilder().applySettings(configRef.getProperties()).build();
			/*------Initializing Session Factory------*/
			sessionfactoryRef = configRef.buildSessionFactory(serviceRegistryRef);
		}
		catch(Throwable tw)
		{
			System.err.println("Unable to print session factory : " + tw);
			throw new ExceptionInInitializerError(tw);
		}
	}
	/*---------Method to return session factory-----------*/
	/*---------Getter method----------*/
	public static SessionFactory getSessionFactory()
	{
		return sessionfactoryRef;
	}
}
