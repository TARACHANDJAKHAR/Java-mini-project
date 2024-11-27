package com.Assignment1java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class User 
{
	public static final String URL="jdbc:mysql://localhost:3306/assignment8";
	public static final String usernamee="root";
	public static final String password1="";
	
      String email;
     
      String username;
      Scanner sc=new Scanner(System.in);
      
    void login(String x,int type) 
    {
		try 
		{
		System.out.println("If you want to change your password :  enter 1 or to continue without changing password :  Enter 0");
		int count=sc.nextInt();
		
		if(count==1) 
		{
			 try 
			  {
			    	Class.forName("com.mysql.cj.jdbc.Driver");
			  }
			 catch(ClassNotFoundException e) 
			  {
			    	System.out.println(e.getMessage());
				
			  }
			 try 
			 {
				    System.out.println("Enter your new password");
				    String updatedpassword=sc.next();
				    
				    String query="update userinfo set password=? ,type=? where username=?";
					Connection con=DriverManager.getConnection(URL, usernamee, password1);
					PreparedStatement st=con.prepareStatement(query);
					
					st.setString(1, updatedpassword);
					st.setInt(2, type);
					st.setString(3, x);
					int row = st.executeUpdate();
					
					if(row>0) 
					{
						System.out.println("Your password updated successfully!!");
					}
					else 
					{
						System.out.println("Update failed");
					}
					
			 }
			 catch(SQLException e) 
			 {
				 e.printStackTrace();
			 }
		}
		else if(count==0) 
		{
		System.out.println("Enter the password : ");
		String y=sc.next(); 
	    try 
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    }
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println(e.getMessage());
	    }
		try 
		{
			String query="select count(*) from userinfo where username= ? and password= ? and type=?";
			Connection con=DriverManager.getConnection(URL, usernamee, password1);
			
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1, x);
			st.setString(2, y);
			st.setInt(3, type);
			
			ResultSet rs=st.executeQuery();
			int res=0;
			
			if(rs.next()) 
			{
				res=rs.getInt(1);
			}
			if(res==0) 
			{
				System.out.println("Invalid Username or password");
				System.out.println();
				System.out.println("wanted to try again:\n 1 for try again  or 0 for exit the application");
				int z=sc.nextInt();
				
				if(z==1) 
				{
					System.out.println("Enter the Username:");
					x=sc.next();
					login(x,type);
				}
				else 
				{
					
					System.exit(0);
				}
			}
			else 
			{
				System.out.println("login successfully");
				System.out.println(" ");
			}
			st.close();
			con.close();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		}
		else 
		{
			System.out.println("Invalid Entry!!!");
			login(x,type);
		 }
		}
		catch(InputMismatchException e) 
		{
			System.out.println("Invalid Entry!!");
			System.out.println("Enter the Username:");
			sc.nextLine();
			x=sc.next();
			login(x,type);
		}
    }
    
    void login(String x) 
    {
    	
		
		System.out.println("Enter the password : ");
		String y=sc.next(); 
		
	    try 
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    }
	    catch(ClassNotFoundException e) 
	    {
	    	System.out.println(e.getMessage());
	    }
		try 
		{
			String query="select count(*) from userinfo1 where username= ? and password= ? ";
			Connection con=DriverManager.getConnection(URL, usernamee, password1);
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, x);
			st.setString(2, y);
			ResultSet rs=st.executeQuery();
			
			int res=0;
			
			if(rs.next()) 
			{
				res=rs.getInt(1);
			}
			if(res==0) 
			{
				System.out.println("Invalid Username or password");
				System.out.println();
				System.out.println("wanted to try again:\n 1 for try again  or 0 for exit the application");
				int z=sc.nextInt();
				
				if(z==1) 
				{
					System.out.println("Enter the username :");
					x=sc.next();
					login(x);
				}
				else 
				{
					System.exit(0);
				}
			}
			else 
			{
				System.out.println("login successfully");
				System.out.println("-------------------");
				this.username=x;
			}
			st.close();
			con.close();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
    }

    
    
     void logout() 
     {
    	 System.out.println("Thank You for using the application !!");
    	 MainManager.main(null);
    	 System.exit(0);
     }
     
    abstract void taskAssigner(String x);
}
