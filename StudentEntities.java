package com.mystudent.hibernate.student.student_hibernate.entities;
import jakarta.persistence.*;
/*------Using  @Entity Annotation to declare java class as an entity------ */
@Entity
/*-----Using @Table Annotation to set table related information----*/
@Table(name = "Student_info")

public class StudentEntities 
{
	/*Using @Id to declare member variables as Primary key*/
	@Id  //Annotation Entity to maintain Primary key
	private String stdId ;
	//Annotation Entity to column
	@Column(name="Student_Name",length = 300,nullable = false)
	private String stdName ;
	
	@Column(nullable = false)
	private int stdAge;
	
	@Column(nullable = false)
	private int stdRoll;
	
	@Column(length = 30, nullable = false)
	private String stdStandard;
	
	@Column(length = 300, nullable = false)
	private String stdAddress;
	
	/*-------------------------Parameterized constructor--------------------------------*/
	public StudentEntities(String stdId,String stdName, int stdAge,int stdRoll, String stdStandard,String stdAddress) 
	{
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdRoll = stdRoll;
		this.stdStandard = stdStandard;
		this.stdAddress = stdAddress;
	}
	/*-----------------------------------------------------------------*/
	public StudentEntities() 
	{
		super(); 	
	}
	/*------------------------------Getter and Setter-----------------------------------*/
	public String getStdId() {return stdId;}
	public void setStdId(String stdId) {this.stdId = stdId;}
	
	public String getStdName() {return stdName;}
	public void setStdName(String stdName) {this.stdName = stdName;}
	
	
	public int getStdAge() {return stdAge;}
	public void setStdAge(int age) {this.stdAge = age;}
	
	public int getStdRoll() {return stdRoll;}
	public void setStdRoll(int stdRoll) {this.stdRoll = stdRoll;}
	
	public String getStdStandard() {return stdStandard;}
	public void setStdStandard(String stdStandard) {this.stdStandard = stdStandard;}
	
	public String getStdAddress() {return stdAddress;}
	public void setStdAddress(String address) {this.stdAddress = address;}
	/*------------------------------To override and convert all data into strings-----------------------------------*/
	@Override
	public String toString() 
	{
		return "\n Student Id :" + stdId + 
				"\n Student Name : " + stdName +
				"\n Age : " + stdAge + 
				"\n Roll Number : " + stdRoll+
				"\n Standard=" + stdStandard + 
				"\n Address : " + stdAddress +
				"\n-------------------------------------------------";
	}		
}

