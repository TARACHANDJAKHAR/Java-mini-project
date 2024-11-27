package com.Assignment1java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainManager 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("1. for adminstration \n2. for student \n3. for Proffesor \n4. for exiting the application");
		System.out.print("Select the type of the user : ");
		
		try 
		{
			String x = null;
			int typeOfUser = sc.nextInt();
			
			if (typeOfUser <= 3 && typeOfUser > 0) 
			{
				System.out.println(" ");
				System.out.println("Enter the username: ");
				x = sc.next();
			}
			User newUser = null;
			
			switch (typeOfUser) 
			{
			case 1:
				newUser = new Admin();
				newUser.login(x);
				break;
			case 2:
				newUser = new Student(x);
				newUser.login(x, typeOfUser);
				break;
			case 3:
				newUser = new Proffesor(x);
				newUser.login(x, typeOfUser);
				break;
			case 4:
				System.out.println("The application is closing!!");
				System.exit(0);
			default:
				System.out.println("Invalid Entry\nEnter the number again ");
				main(null);
				System.exit(0);
			}

			newUser.taskAssigner(x);
			
		} 
		catch (InputMismatchException e) 
		{
			System.out.println("Invalid Entry");
			main(null);
			System.exit(0);
		}

		finally 
		{
			sc.close();
		}

		// sc.close();

	}

}
