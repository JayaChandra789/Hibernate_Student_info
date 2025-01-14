package com.mystudent.hibernate.student.student_hibernate.dto;
/* DTO: Data Transfer Object */
/* DTOs are used to transfer only specific pieces of data from the database, 
 * instead of accessing the entire entity object, which might contain sensitive or unnecessary information. 
 * This improves security and minimizes data exposure. */
/* A DTO class is created separately to define the exact structure of data to be fetched and used, 
 * without directly exposing the entity class. */

public class StudentIdNameAgeDTO 
{
	private String stdId;
	private String stdName;
	private int age;
	public StudentIdNameAgeDTO(String stdId, String stdName, int age) 
	{
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.age = age;
	}
	public StudentIdNameAgeDTO() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getStdId(){return stdId;}
	public void setStdId(String stdId){this.stdId = stdId;}
	
	public String getStdName(){return stdName;}
	public void setStdName(String stdName){this.stdName = stdName;}
	
	public int getAge(){return age;}
	public void setAge(int age) {this.age = age;}
	
	@Override
	public String toString() 
	{
		return "Sstudent Id : " + stdId + 
				"\n student Name: " + stdName + 
				"\n Age : " + age + 
				"year\n-------------------------------------\n";
	}
}
