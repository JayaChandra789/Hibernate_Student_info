package com.mystudent.hibernate.student.student_hibernate.coursefk;

import jakarta.persistence.*;
import com.mystudent.hibernate.student.student_hibernate.entities.*;
/*------Using  @Entity Annotation to declare java class as an entity------ */
@Entity
/*-----Using @Table Annotation to set table related information----*/
@Table(name = "CourseDetails")
public class CourseDetailsEntities 
{
	@Id
	private String courseId;
	@Column(name="CourseName",length = 300,nullable = false)
	private String courseName;
	@Column(nullable = false)
	private String courseCode;
	@Column(nullable = false)
	private int courseDuration;
	
	public CourseDetailsEntities(String courseId, String courseName,String courseCode, int courseDuration) 
	{
		super();
		this.courseId =   courseId;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseDuration = courseDuration;
	}
	public CourseDetailsEntities() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	/*-------------------------------------Getter and Setters---------------------------------------*/
	public String getCourseId() {return courseId;}

	public void setCourseId(String courseId) {this.courseId = courseId;}
	/*-----------------------------------------------------------------------------------------*/
	public String getCourseName() {return courseName;}

	public void setCourseName(String courseName) {this.courseName = courseName;}
	/*-----------------------------------------------------------------------------------------*/
	public String getCourseCode() {return courseCode;}

	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
	/*-----------------------------------------------------------------------------------------*/
	public int getCourseDuration() {return courseDuration;}

	public void setCourseDuration(int courseDuration) {this.courseDuration = courseDuration;}

	@Override
	public String toString() 
	{
		return    "\n course Id: " + courseId 
				+ "\n course Name: " + courseName
				+ "\n Course Code: " + courseCode
				+ "\n course Duration: "+ courseDuration ;
	}
}
