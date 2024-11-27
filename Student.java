package com.Assignment1java;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Student extends User
{
     String name;
     String department;
     int semester;
  
     Student(String username1)
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
     			String query="select * from students where StudentID= ?";
     			Connection con=DriverManager.getConnection(URL, usernamee, password1);
     			
     			PreparedStatement st=con.prepareStatement(query);
     			st.setString(1, username1);
     			ResultSet rs=st.executeQuery();
     			
     			while(rs.next()) 
     			{
     				this.name=rs.getString("Name");
     				this.department=rs.getString("department");
     				this.semester=rs.getInt("semester");
     				this.email=rs.getString("email");
     			}
         }	
       	catch(SQLException e) 
       	{
     		e.printStackTrace();
     	}
       	}
     Scanner sc1=new Scanner(System.in);
     
    void taskAssigner(String username1) 
    {
	try 
	{
	System.out.println("Enter the key corresponding to task:");
	
	System.out.println("1: View your Information");
	System.out.println("2: View available Courses   ");
	System.out.println("3: To view the schedule");
	System.out.println("4: To register in course");
	System.out.println("5: To find your result ");
	System.out.println("6: have to take drop ");
	System.out.println("7: to submit a complain");
	System.out.println("0: to logout ");
	
	int choice=-1;
	choice=sc1.nextInt();
	
	switch(choice) 
	{
	case 1:
		displayInformation(username1);
		break;
	case 2:
		viewCourses(username1);
		break;
	case 3:
		viewSchedule(username1);
		break;
	case 4:
		doRegistration(username1);
		break;
	case 5:
		result(username1);
		break;
	case 6:
		dropcourse(username1);
		break;
	case 7:
		tosubmit(username1);
		break;
	case 0:
		logout();
		break;
	default:
		System.out.println("You  entered wrong key for task ");
		taskAssigner(username1);
		
	}
	}
	catch(InputMismatchException e) 
	{
		System.out.println("Invalid Entry!!");
		 sc.nextLine();
		taskAssigner(username1);
	}

    }
    
    

    
    
	 
	void displayInformation(String username1) 
	{
			System.out.println("__________________");
			System.out.println("Your information is :");
			System.out.println("   Username : "+username1);
			System.out.println("   Name : "+name);
			System.out.println("   Department : "+department);
			System.out.println("   Email : "+email);
			taskAssigner(username1);
    }
	
	

	
    void viewCourses(String username1) 
    {
    	String query="Select CourseID, CourseName,credits,pre,syllabus from course where department= ? and semester=?";
    	Connection con;
    	
		try 
		{
			con = DriverManager.getConnection(URL, usernamee, password1);
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, this.department);
			st.setInt(2,this.semester);
			
			ResultSet rs=st.executeQuery();
			System.out.println("The course are :");
			
			System.out.println("+----------------+--------------------------------+-------------------------------+-----------------+--------------------+");
			System.out.println("| Course ID      | Course Name                    | Pre-req                       | Credits         |  Syllabus          |");
			System.out.println("+----------------+--------------------------------+-------------------------------+-----------------+--------------------+");
    		
    		while(rs.next()) 
    		{
    				System.out.printf( "| %-14d | %-30s | %-30s | %-15d | %-18s |" ,rs.getInt("courseid") , rs.getString("coursename") , rs.getString("pre") , rs.getInt("credits") ,rs.getString("syllabus") );
    				System.out.println("");
       			
    		}
			System.out.println("+----------------+--------------------------------+--------------------------------+-----------------+--------------------+");
			
			rs.close();
			st.close();
			con.close();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		taskAssigner(username1); 
		
    }
    
    
	Vector<Integer> course = new Vector<>();
	
	private	void methodcourse() 
	{
	 	String query="Select CourseID from course where department= ? and semester=?";
		Connection con=null;
		
		try 
		{
			con = DriverManager.getConnection(URL, usernamee, password1);
			PreparedStatement st=con.prepareStatement(query);
			
			st.setString(1, this.department);
			st.setInt(2,this.semester);
			ResultSet rs=st.executeQuery();
			
//			if(rs.next()==false) 
//			{
//				System.out.println("invalid");
//			}
			while(rs.next()) 
			{
				course.add(rs.getInt("CourseID"));
			}
			
		} 
		catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		}
    
    
    
    void doRegistration(String username1) 
    {
    	     try 
    	     {
    		 Connection con;
    		 String query="Select * from result where studentid=?";
    		 
    		 try 
    		 {
    				con = DriverManager.getConnection(URL, usernamee, password1);
    				PreparedStatement st=con.prepareStatement(query);
    				
    				st.setString(1, username1);
    				ResultSet rs=st.executeQuery();
    				int count=0;
    				
    				while(rs.next()) 
    				{
    					if("F".equals(rs.getString("course1"))) count++; 
    					if("F".equals(rs.getString("course2"))) count++; 
    					if("F".equals(rs.getString("course3"))) count++; 
    					if("F".equals(rs.getString("course4"))) count++; 
    					if("F".equals(rs.getString("course5"))) count++; 
    				}
    				if(count>=3) 
    				{
    					System.out.println("Registrtion cannot be done");
    				}
    				else 
    				{
    				    methodcourse();
    				    
    					  String query1="INSERT INTO Registration (StudentID, CourseID) VALUES (?, ?);";
    					  Connection con1;
    					    System.out.print("Enter the course you want to register: ");
				            int courseid=sc.nextInt(); 
				            
    			            int flag=0;
				            for(int vec:course) 
				            {
				            	if(vec==courseid) 
				            	{
				            		flag=1;
				            		break;
				            	}
				            }
				            if(flag==0) 
				            {
				            	System.out.println("this course is not your depatment");
				            
				            }
				            else 
				            { 
    					 try 
    					 {
    						 con1 = DriverManager.getConnection(URL, usernamee, password1);
    				             PreparedStatement st1 = con1.prepareStatement(query1);
    				            st1.setString(1, username1);
    				            st1.setInt(2, courseid);

    				            
    				            int rowsInserted = st1.executeUpdate();
    				            if (rowsInserted > 0) 
    				            {
    				                System.out.println("A new registration was inserted successfully!");
    				            }
    				        } 
    					 catch (SQLException e) 
    					 {
    				            System.out.println("Registration already done");
    				     }
    					   System.out.print("Wanted to view your registered courses: then type 1 otherwise 0\n");
    			    	 int y=sc1.nextInt();
    			    	 if(y==1) 
    			    	 {
    			    	 viewregister(username1);
    			    	 }
				            }
    				    }
    				
    		 }
    		 catch(SQLException e) 
    		 {
    			 e.printStackTrace();
    		 }
    	
    	 
    	 
    	 taskAssigner(username1);
    	     }
    	     catch(InputMismatchException e) 
    	     {
    	 		System.out.println("Invalid Entry!!");
    	 		 sc.nextLine();
    	 		doRegistration(username1);
    	 	}
    }
    
    
    
    
  






	void viewSchedule(String username1) {
    	Connection con ;
        String query = "SELECT p.Name AS ProfessorName,s.Timing,s.RoomNo,c.CourseName FROM SCHEDULE s natural JOIN ProfessorCourse pc natural JOIN Professor p natural JOIN Course c WHERE c.Semester = ? AND c.Department = ? ;";

 try {
     con = DriverManager.getConnection(URL, usernamee, password1);
     PreparedStatement st = con.prepareStatement(query);
     st.setInt(1, this.semester);
     st.setString(2, this.department);
     ResultSet rs = st.executeQuery();
     System.out.println("+--------------------+----------------------+------------+--------------------------------+");
     System.out.println("| Professor Name     | Timing               | Room No    | Course Name                    |");
     System.out.println("+--------------------+----------------------+------------+--------------------------------+");
     while (rs.next()) {
         String professorName = rs.getString("ProfessorName");
         String timing = rs.getString("Timing");
         String roomNo = rs.getString("RoomNo");
         String courseName = rs.getString("CourseName");
        
         
         System.out.printf("| %-18s | %-20s | %-10s | %-30s |\n", professorName, timing, roomNo, courseName);
     }

     System.out.println("+--------------------+----------------------+------------+--------------------------------+");
			
      }catch(SQLException e) {
    	  e.printStackTrace();
      }
           taskAssigner(username1);
    }
        
    void result(String username1) {
		// TODO Auto-generated method stub
    	if(this.semester==1) {
    		System.out.println("You dont have result to see!!");
    	}
    	else{
    	String query="select course1,course2,course3,course4,course5,totalcredit from result where studentid=?";
    	Connection con;
    	try {
    		 con = DriverManager.getConnection(URL, usernamee, password1);
    		 PreparedStatement st = con.prepareStatement(query);
    		 st.setString(1, username1);
    		 String[] a=new String[5];
    		 int totalcredit = 0;
    		 ResultSet rs=st.executeQuery();
    		 while(rs.next()) {
    			a[0]=rs.getString("course1");
    			a[1]=rs.getString("course2");
    			a[2]=rs.getString("course3");
    			a[3]=rs.getString("course4");
    			a[4]=rs.getString("course5");
    			totalcredit=rs.getInt("totalcredit");
    		 }
    		 int sum=0;
    		 for(int i=0;i<5;i++) {
    			 System.out.println("The grade of the student is in course"+(i+1)+"  is "+a[i]);
    			 switch (a[i]) {
                 case "A":
                     sum+= 10; 
                     break;
                 case "B":
                     sum += 8;
                     break;
                 case "C":
                     sum+= 6; 
                     break;
                 case "D":
                    sum += 4;
                     break;
                 case "F":
                     sum += 0;
                    
                     break;
    		 }
    		 
    		 }
    	  	int ttotalcredit=sum+totalcredit;
    	  	System.out.println("\n\n");
    	  	System.out.println("The SGPA is :"+(double)sum/5);
    	  	System.out.println("The CGPA is :"+(double)ttotalcredit/((this.semester-1)*20));
    	  	 taskAssigner(username1);
    	  	
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}}
    	}
    
    
    
    
    
    void dropcourse(String username1) {
		
	    try {

        System.out.print("Enter the Course ID to drop: ");
        int courseID = sc1.nextInt();

        String query = "DELETE FROM Registration WHERE StudentID = ? AND CourseID = ?";

        try {
        	Connection con = DriverManager.getConnection(URL, usernamee, password1);
             PreparedStatement pst = con.prepareStatement(query);

           
            pst.setInt(1, Integer.parseInt(username1));
            pst.setInt(2, courseID);

            
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registration deleted successfully!");
            } else {
                System.out.println("No registration found for the given Student ID and Course ID.");
            }

        } catch (SQLException e) {
        	System.out.println("Some error happended");
            e.printStackTrace();
        } 
        System.out.print("Wanted to view your registered courses: then type 1 otherwise 0");
   	     int y=sc1.nextInt();
   	    if(y==1) {
   	     viewregister(username1);}
   	 
			taskAssigner(username1);
	    }catch(InputMismatchException e) {
	 		System.out.println("Invalid Entry!!");
	 		dropcourse(username1);
	 	}
			
	}
    
    
    

	 void tosubmit(String username1) {
         
		 System.out.println("Enter 1 if you want to check your status and 0 if you want to complain:");
		  int checkstatus=sc1.nextInt();
		  
		  if(checkstatus==0) {
		  String query="INSERT INTO inquiry (studentid, quer) values(?,?) ";
		
		  System.out.println("Enter your complaint :");
		  sc1.nextLine();
		  String yourQuery=sc1.nextLine();
		  Connection con;
		  try {
			  con=DriverManager.getConnection(URL, usernamee, password1);
			  PreparedStatement st=con.prepareStatement(query);
			  st.setString(1, username1);
			  st.setString(2,yourQuery );
			  int rs=st.executeUpdate();
			  if(rs>0) {
				  System.out.println("Your complaint is registered");
			  }
			  else {
				  System.out.println("Your complaint is not registered");
			  }
			  
		
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }}
		  else {
				  String query1="Select status,quer from inquiry where studentid=?";
				  Connection con1;
				  try {
					  con1=DriverManager.getConnection(URL, usernamee, password1);
					  PreparedStatement st1=con1.prepareStatement(query1);
					  st1.setString(1, username1);
					  ResultSet rs1=st1.executeQuery();
					  while(rs1.next()) {
						  if(rs1.getString("status").equals("pending")) {
							  System.out.println("Your complaint  "+rs1.getString("quer") +" is still pending !!");
						  }
						  else {
							  System.out.println("Your complaint "+rs1.getString("quer") +" is resolve :");
						  }
					  }
				  }catch(SQLException e) {
					  e.printStackTrace();
				  }
			  
		  }
		  taskAssigner(username1);
	}
	

	 
	  
	    private void viewregister(String username1) {
			// TODO Auto-generated method stub
	    	String query="SELECT StudentID, CourseID, RegistrationDate FROM Registration where studentid = ?;";
	    	try { 
	    		Connection con = DriverManager.getConnection(URL, usernamee, password1);
	                PreparedStatement st = con.prepareStatement(query);
	                st.setInt(1, Integer.parseInt(username1));
	                ResultSet rs = st.executeQuery();

	               
	               System.out.printf("%-15s %-15s %-25s%n", "Student ID", "Course ID", "Registration Date");
	               System.out.println("-----------------------------------------------------");

	              
	               while (rs.next()) {
	                   int studentID = rs.getInt("StudentID");
	                   int courseID = rs.getInt("CourseID");
	                   java.sql.Timestamp registrationDate = rs.getTimestamp("RegistrationDate");

	                  
	                   System.out.printf("%-15d %-15d %-25s%n", studentID, courseID, registrationDate);
	               }
	           } catch (SQLException e) {
	               System.out.println("some error happened!!");
	           }
			
		}
	    
	    
	
	 
}


