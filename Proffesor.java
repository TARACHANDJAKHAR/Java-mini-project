package com.Assignment1java;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Proffesor extends User
{    String pname;
	Proffesor(String username1){

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
      	try {
    			String query="select * from professor where professorid= ?";
    			Connection con=DriverManager.getConnection(URL, usernamee, password1);
    			PreparedStatement st=con.prepareStatement(query);
    			st.setString(1, username1);
    			ResultSet rs=st.executeQuery();
    			while(rs.next()) {
    				this.pname=rs.getString("Name");
    				this.email=rs.getString("email");
    			    this.username=username1;
    			}
        }	catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	 Scanner sc=new Scanner(System.in);
	@Override
	void taskAssigner(String username1) {
		try {
	    System.out.println("Enter the corresponding key of task you want to perform :");
	    System.out.println("1: to manage courses");
	    System.out.println("2: Enrolled Student ");
	    System.out.println("0: Logout the program ");
	    
	    int task=sc.nextInt();
	   
	    switch(task) {
	    case 1:
	    	manage(username1);
	    	break;
	    case 2:
	    	studentList(username1);
	    	break;
	    case 0:
	    	logout();
	    	break;
	    default:
	    	System.out.println("Invalid Entry !!");
	    	taskAssigner(username1);
	    }
		}catch(InputMismatchException e) {
			System.out.println("Invalid Entry!!");
			 sc.nextLine();
			taskAssigner(username1);
		}
		
	}
	  Vector<String> vec = new Vector<>();

	void manage(String username1 ) {
		try {
		  viewcourses(username1,1);

	      System.out.println("Enter the corresponding task key you want to do:");
	    	 System.out.println("1: update class timing");
	    	 System.out.println("2: update credits");
	    	 System.out.println("3 : update prerequisitics");
	    	 System.out.println("4: View Courses");
	    	 System.out.println("5: Update Syllabus");
	    	 
	    	 
	    	 int choosemanage=sc.nextInt();
    	  if(choosemanage==1) {
    		 System.out.println("Enter the courseid whose timing you have to change:");
    		 String courseid1=sc.next();
    		 int flag=0;
    		 for(String s:vec) {
    			 if(s.equals(courseid1)) {
    				 flag=1;
    				 break;
    			 }
    		 }
    		 if(flag==0) {
    			 System.out.println("This course does not belong to you");
    			 taskAssigner(username1);
    		 }
    		 else {
    		 String query1="update schedule set timing= ? where courseid=? ;";
    		 System.out.println("enter the new timing");
    		 String timing=sc.next();
    		 try {
    			 Connection con1=DriverManager.getConnection(URL, usernamee, password1);
				PreparedStatement st1 = con1.prepareStatement(query1);
				st1.setString(1, timing);
				st1.setString(2, courseid1);
				int rs=st1.executeUpdate();
				if(rs>0) {
					System.out.println("The updation successful");
				}
				else {
					System.out.println("some error happened");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
    		 System.out.println("Want to check your updated schedule then enter 1 or 0");
    		 sc.nextLine();
    		 int ke=sc.nextInt();
    		 if(ke==1) {
    			 viewschedule(username1);
    		 }
    	 }
    	  else if(choosemanage==2) {
    		  viewcourses(username1,1);
    		  System.out.println("Enter the courseid whose credit you have to change:");
     		 String courseid1=sc.next();
    		  int flag=0;
     		 for(String s:vec) {
     			 if(s.equals(courseid1)) {
     				 flag=1;
     				 break;
     			 }
     		 }
     		 if(flag==0) {
     			 System.out.println("This course does not belong to you");
     			 taskAssigner(username1);
     		 } else {
     		 String query1="update course set credits= ? where courseid=? ;";
    		 System.out.println("enter the new credit");
    		 int credit=sc.nextInt();
    		 try {
    			 Connection con1=DriverManager.getConnection(URL, usernamee, password1);
				PreparedStatement st1 = con1.prepareStatement(query1);
				st1.setInt(1,credit );
				st1.setString(2, courseid1);
				int rs=st1.executeUpdate();
				if(rs>0) {
					System.out.println("The updation successful");
				}
				else {
					System.out.println("some error happened");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Some sql error is happening");
				e.printStackTrace();
			}}
     		 
    	  }
    	  else if(choosemanage==3) {
    		  System.out.println("Enter the courseid whose prerequisitics you have to change:");
      		 String courseid1=sc.next();
     		  int flag=0;
      		 for(String s:vec) {
      			 if(s.equals(courseid1)) {
      				 flag=1;
      				 break;
      			 }
      		 }
      		 if(flag==0) {
      			 System.out.println("This course does not belong to you");
      			 taskAssigner(username1);
      		 } else {
      		 String query1="update course set pre= ? where courseid=? ;";
     		 System.out.println("enter the new prerequisite");
     		 sc.nextLine();
     		 String  pre=sc.nextLine();
     		 
     		 try {
     			 Connection con1=DriverManager.getConnection(URL, usernamee, password1);
 				PreparedStatement st1 = con1.prepareStatement(query1);
 				st1.setString(1,pre );
 				st1.setString(2, courseid1);
 				int rs=st1.executeUpdate();
 				if(rs>0) {
 					System.out.println("The updation successful");
 				}
 				else {
 					System.out.println("some error happened");
 				}
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} }
    	  }
    	  else if(choosemanage==4) {
    		  viewcourses(username1,0);
    	  }
    	  else if(choosemanage==5) {
    		
    		  String query = "UPDATE Course SET Syllabus = ? WHERE CourseID = ?";

    		  try {
    		      Connection con = DriverManager.getConnection(URL, usernamee, password1);
    		      PreparedStatement st = con.prepareStatement(query);

    		      sc.nextLine();
    		      System.out.println("Enter the new syllabus:");
    		      String syllabus = sc.nextLine(); 
    		      System.out.println("Enter the Course ID:");
    		      String courseid = sc.next();
    			  int flag=0;
    	      		 for(String s:vec) {
    	      			 if(s.equals(courseid)) {
    	      				 flag=1;
    	      				 break;
    	      			 }
    	      		 }
                   if(flag==0) {
                	   System.out.println("This course does not belong to you!!");
                   }
                   else {
    		      st.setString(1, syllabus); 
    		      st.setInt(2, Integer.parseInt(courseid));    

    		      
    		      int rowsUpdated = st.executeUpdate();
    		      if (rowsUpdated > 0) {
    		          System.out.println("The syllabus was updated successfully.");
    		      }

    		      
    		      st.close();
    		      con.close();
                   }  } catch (SQLException e) {
    		      e.printStackTrace();
    		  }

    	  }
    	  else {
    		  System.out.println("Wrong Input!!");
    	  }
    	  taskAssigner(username1);  
		}catch(InputMismatchException e) {
			System.out.println("Invalid Entry !!");
			 sc.nextLine();
			manage(username1);
		}
	}
	
	
	
	
    private void studentList(String username1) {
    	try {
		// TODO Auto-generated method stub
    	String query1="SELECT s.studentid, s.name, s.department, s.semester, s.email FROM Registration r JOIN ProfessorCourse pc ON r.CourseID = pc.CourseID JOIN Students s ON r.StudentID = s.StudentID WHERE pc.ProfessorID = ?;";
    		
    	 Connection con1;
    	    Vector<Integer> studentid=new Vector<>();
			Vector<String> name = new Vector<>();
			Vector<String> department = new Vector<>();
			Vector<Integer> semester = new Vector<>();
			Vector<String> email = new Vector<>();
		
		try {
			con1 = DriverManager.getConnection(URL, usernamee, password1);
			PreparedStatement st1 = con1.prepareStatement(query1);
			st1.setString(1, username1);
			ResultSet rs=st1.executeQuery();
			
			while(rs.next()) {
				studentid.add(rs.getInt("s.studentid"));
				name.add(rs.getString("s.name"));
				department.add(rs.getString("s.department"));
				semester.add(rs.getInt("s.semester"));
				email.add(rs.getString("s.email"));
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n=name.size();
		System.out.println("The list of the student with their detail that are enrolled in your courses are:");
        System.out.println("");
        
        System.out.println("+------------+-----------------+------------+------------+------------------------+");
		System.out.println("| Student ID | Student Name    | Department | Semester   | Email                  |");
		System.out.println("+------------+-----------------+------------+------------+------------------------+");		
		
		for(int i=0;i<n;i++) 
		{
			System.out.printf("| %-10d | %-15s | %-10d | %-10d | %-22s |" , studentid.elementAt(i) , name.elementAt(i) , department.elementAt(i) , semester.elementAt(i) , email.elementAt(i) );
			System.out.println();
			
		}
		
		System.out.println("+------------+-----------------+------------+------------+------------------------+");
		
		taskAssigner(username1);
        }
		catch(InputMismatchException e) {
			System.out.println("Invalid Entry !!");
			 sc.nextLine();
			studentList(username1);
		}
    }
     
    
    void viewcourses(String username1,int x) {
   
    String query="select coursename,courseid,credits,pre,syllabus from course where courseid in (select courseid from PROFESSORCOURse where professorid=?);";
     Connection con ;
     try {
   	    con=DriverManager.getConnection(URL, usernamee, password1);
   		PreparedStatement st=con.prepareStatement(query);
   		st.setString(1, username1);
   		ResultSet rs=st.executeQuery();
   		if(x == 0) {
   	        System.out.println("The courses taught by you:");

   	        System.out.println("+----------------+--------------------------------+-------------------+-------------------------------+---------------------------+");
   	        System.out.println("| Course ID      | Course Name                    | Credits           | Pre-req                       | Syllabus                  |");
   	        System.out.println("+----------------+--------------------------------+-------------------+-------------------------------+---------------------------+");
   	    }
   	    
   	    while(rs.next()) {
   	        vec.add(rs.getString("courseid"));
   	        
   	        if(x == 0) {
   	            System.out.printf("| %-14d | %-30s | %-17d | %-30s | %-25s |", rs.getInt("courseid"),  rs.getString("coursename"),   rs.getInt("credits"),  rs.getString("pre"), rs.getString("syllabus"));
   	            System.out.println();
   	        }
   	    }
   	    
   	    System.out.println("+----------------+--------------------------------+-------------------+-------------------------------+---------------------------+");
     }catch(SQLException e) {
   	  e.printStackTrace();
     }}

    
    
    void viewschedule(String username1) {
    	String query = "SELECT pc.ProfessorID, s.CourseID, s.Timing FROM SCHEDULE s JOIN ProfessorCourse pc ON s.CourseID = pc.CourseID WHERE pc.ProfessorID = ?";


        try {
            
            Connection con = DriverManager.getConnection(URL, usernamee, password1);
            PreparedStatement st = con.prepareStatement(query);

           
            st.setInt(1, Integer.parseInt(username1));

            ResultSet rs = st.executeQuery();

            System.out.println("+----------------+------------+--------------------------------+");
			System.out.println("| ProfessorID    | Course ID  | Timing                         |");
			System.out.println("+----------------+------------+--------------------------------+");
    		
    		while(rs.next()) 
    		{
    			System.out.printf( "| %-14d | %-10d | %-30s |" , rs.getInt("ProfessorID") ,rs.getInt("courseid") , rs.getString("Timing"));
    			System.out.println("");
    		}

			System.out.println("+----------------+------------+--------------------------------+");
            
            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
