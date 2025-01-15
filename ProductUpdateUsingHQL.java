package com.mystudent.hibernate.student.student_hibernate.product;

import java.io.*; //

import org.hibernate.Session;//
import org.hibernate.Transaction;//
import org.hibernate.query.Query;//

import com.mystudent.hibernate.student.student_hibernate.utility.StudentUtility;//

public class ProductUpdateUsingHQL 
{
	public static void main(String[] args) throws IOException
	{
		// Creating object of BufferedReader class to receive input of data through keyboard
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Product id : ");
		String productId = br.readLine();
		
		System.out.print("Enter Product name : ");
		String productName = br.readLine();
		
		System.out.print("Enter Product cost : ");
		float productCost = Float.parseFloat(br.readLine());
		
		System.out.print("Enter Product Quantity : ");
		int productQuantity = Integer.parseInt(br.readLine());
		System.out.println("------------------------------------");
		/*-----------------------------------------------------------------------*/
		//Creating session reference
		Session session = StudentUtility.getSessionFactory().openSession();
		/*--- Creating reference of Transaction -------*/
		Transaction transaction = session.beginTransaction();
		//Creating reference of Query interface ----
		Query query = session.createQuery("update Product set name =: x, price =: y, quantity =: z where productId =: m");

		/*---- setting data into the parameter -----*/
		 //We need to set parameters for each argument each parameter or variable should be different.
		query.setParameter("x", productName);
        query.setParameter("y", productCost);
        query.setParameter("z", productQuantity);
        query.setParameter("m", productId);
        //Arrange as per the query...name,price,quantity,productId
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
