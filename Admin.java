package com.Assignment1java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User 
{   
	Admin(){
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }
	}
	Scanner sc=new Scanner(System.in);
	@Override
	void taskAssigner(String username1) throws InputMismatchException
	{
		// TODO Auto-generated method stub
		  try {
		   System.out.println("Enter the corresponding key of task you want to perform :");
		    System.out.println("1: to manage courses ");
		    System.out.println("2: Enrolled Student ");
		    System.out.println("3: Assign Course");
		    System.out.println("4: Complaint Query");
		    System.out.println("0: Logout the program ");
		    int task=sc.nextInt();
		   
		    switch(task) {
		    case 1:
		    	manageCourse(username1);
		    	break;
		    case 2:
		    	managestudent(username1);
		    	break;
		    case 3:
		    	assignCourse(username1);
		    	break;
		    case 4:
		    	complainquery(username1);
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




		void manageCourse(String username1) {
		    try {
	    	System.out.println("Enter the coressponding key task you want to done in course:");
	    	System.out.println("1 : View the courses");
	    	System.out.println("2:  Delete the course ");
	    	System.out.println("3:  Add the course ");
	    	int key=sc.nextInt();
	    	Connection con=null;
	    	if(key==1) {
	    		String query="select CourseID, CourseName from course where semester =? and department =?";
	    		 try {
	    			 System.out.println("Enter the semester you want to view the course :");
	    			 int semester=sc.nextInt();
	    			 System.out.println("Enter the department  you want to view the course :");
	    			 sc.nextLine();
	    			 String department=sc.nextLine();
					con=DriverManager.getConnection(URL, usernamee, password1);
					PreparedStatement st=con.prepareStatement(query);
		    		st.setInt(1, semester);
		    		st.setString(2, department);
		    		ResultSet rs=st.executeQuery();
		    			    	
		    		System.out.println("+----------------+---------------------------+");
					System.out.println("| Course ID      | Course Name               |");
					System.out.println("+----------------+---------------------------+");
		    		
		    		while(rs.next()) 
		    		{
		    			System.out.printf( "| %-14d | %-25s |" ,rs.getInt("courseid") , rs.getString("coursename"));
		    			System.out.println("");
		    		}
		    		
					System.out.println("+----------------+---------------------------+");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	    	
	    	}
	    	else if(key==2) {
	    		String query = "DELETE FROM Course WHERE CourseID = ?";
	    		try {
	    			System.out.println("Enter the course id you want to delete :");
	    			int courseID=sc.nextInt();
	    		    con = DriverManager.getConnection(URL, usernamee, password1);
	    		    PreparedStatement st = con.prepareStatement(query);
	    		    st.setInt(1, courseID);
	    		    int row = st.executeUpdate();
	    		    if (row> 0) {
	    		        System.out.println("Course with CourseID " + courseID + " was successfully deleted.");
	    		    } else {
	    		        System.out.println("No course found with CourseID " + courseID);
	    		    }
	    		} catch (SQLException e) {
	    		    e.printStackTrace();
	    		}

	    	}
	    	else if(key==3) {
	    		String insertQuery = "INSERT INTO Course (CourseID, CourseName, Department, Semester, Credits) VALUES (?, ?, ?, ?, ?)";
	    		try {
	    		    con = DriverManager.getConnection(URL, usernamee, password1);
	    		    PreparedStatement st = con.prepareStatement(insertQuery);
                     System.out.println("Enter the course detail you want to add:");
                     System.out.println("Enter the courseid");
	    		     int courseid=sc.nextInt();
	    		     sc.nextLine();
	    		     System.out.println("Enter the course name ");
	    		     String coursename=sc.nextLine();
	    		     System.out.println("Enter the department");
	    		 
	    		     String department=sc.nextLine();
	    		     System.out.println("Enter the semester ");
	    		     int semester=sc.nextInt();
	    		     System.out.println("Enter the credits");
	    		     int credit=sc.nextInt();
	    		     
	    		    st.setInt(1, courseid);           
	    		    st.setString(2, coursename);       
	    		    st.setString(3, department);      
	    		    st.setInt(4, semester);            
	    		    st.setInt(5, credit);             
	    		    int rowsInserted = st.executeUpdate();
	    		    if (rowsInserted > 0) {
	    		        System.out.println("A new course was inserted successfully!");
	    		    }
	    		} catch (SQLException e) {
	    		    e.printStackTrace();
	    		}

	    	}
	    	taskAssigner(username1);
		    }catch(InputMismatchException e) {
				  System.out.println("Invalid Entry!!");
				  sc.nextLine();
				  manageCourse(username1);
			  }
	}
		
		
		
		
		    void managestudent(String username1) {
		    	try {
			  System.out.println("Enter the function key you want to do:");
			  System.out.println("1: view the student data");
			  System.out.println("2: Delete  the student data permanately");
			  System.out.println("3: Update a student data");
			  System.out.println("4: Update the grade of the student ");
			  System.out.println("5: Add a student ");
			 int key=sc.nextInt();
			 Connection con=null;
			 if(key==1) {
				   String query = "SELECT StudentID, Name, Department, Semester, Email FROM Students WHERE Department = ? AND Semester = ?";
				   
				    try {
				        con = DriverManager.getConnection(URL, usernamee, password1);
				        PreparedStatement st = con.prepareStatement(query);
				        
				        System.out.println("Enter the department student data you want to know: ");
				        sc.nextLine();
				        String department=sc.nextLine();
				        System.out.println("Enter the semester  of student : ");

				        int semester=sc.nextInt();
				        st.setString(1, department);
				        st.setInt(2, semester);
				        
				        ResultSet rs = st.executeQuery();
				        System.out.println("Student information for Department: " + department + ", Semester: " + semester);
				        
				        System.out.println("+------------+-----------------+----------------------------+-----------------+------------------------+");
						System.out.println("| Student ID | Student Name    | Department                 | Semester        | Email                  |");
						System.out.println("+------------+-----------------+----------------------------+-----------------+------------------------+");
						
				        
				        while (rs.next()) 
				        {
				        	System.out.printf("| %-10d | %-15s | %-26s | %-15s | %-22s |" , rs.getInt("StudentID") , rs.getString("Name") , rs.getString("Department") , rs.getInt("Semester") , rs.getString("Email") );
				        	System.out.println();
				        }
				        
				        System.out.println("+------------+-----------------+----------------------------+-----------------+------------------------+");
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				
			 }
			 else if (key==2) {
				   String query = "DELETE FROM Students WHERE StudentID = ?";
				    
				    try {
				        con = DriverManager.getConnection(URL, usernamee, password1);
				        PreparedStatement st = con.prepareStatement(query);
				        
				        System.out.println("Enter the student id who you want to remove ");
				        int studentid=sc.nextInt();
				        st.setInt(1, studentid);
				        
				        int r = st.executeUpdate();
				        if (r > 0) {
				            System.out.println("Student with StudentID " + studentid + " was successfully deleted.");
				        } else {
				            System.out.println("No student found with StudentID " + studentid);
				        }
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
			 }
			 else if(key==3) {
				  String query = "UPDATE Students SET Name = ?, Department = ?, Semester = ?, Email = ? WHERE StudentID = ?";
				   
				    try {
				        con = DriverManager.getConnection(URL, usernamee, password1);
				        PreparedStatement st = con.prepareStatement(query);
				        System.out.println("Enter the detail of student you want to update:");
				        System.out.println("Enter the student id ");
				        int studentid=sc.nextInt();
				        sc.nextLine();
				        System.out.println("Update the name of the student :");
				        String name=sc.nextLine();
				        System.out.println("Update the department you want to add:");
				        String department=sc.nextLine();
				        System.out.println("Update the semester");
				        int semester=sc.nextInt();
				        System.out.println("Update the created email");
				        sc.nextLine();
				        String emaill=sc.nextLine();
				        
				        st.setInt(5, studentid);
				        st.setString(1, name);
				        st.setString(2, department);
				        st.setInt(3, semester);
				        st.setString(4, emaill);
				        
				        int rowsInserted = st.executeUpdate();
				        if (rowsInserted > 0) {
				            System.out.println("Student was updated successfully.");
				        }
				       
				    } catch (SQLException e) {
				    	System.out.println("Some Error happened!!");
				        e.getMessage();
				    }
			 }
			 else if(key==4) {
				   String query = "UPDATE Result SET Course1 = ?, Course2 = ?, Course3 = ?, Course4 = ?, Course5 = ? WHERE StudentID = ?";
				   PreparedStatement st = null;
			        try {
			            con = DriverManager.getConnection(URL, usernamee, password1);
			            st = con.prepareStatement(query);
                        System.out.println("Enter the student id where we want to update the result:");
                        int studentid= sc.nextInt();
                        System.out.println("Enter the grade in course 1");
                        String course11=sc.next();
                        System.out.println("Enter the grade in course 2");
                        String course12=sc.next();
                        System.out.println("Enter the grade in course 3");
                        String course13=sc.next();
                        System.out.println("Enter the grade in course 4");
                        String course14=sc.next();
                        System.out.println("Enter the grade in course 5");
                        String course15=sc.next();
			            
			            st.setString(1, course11);  
			            st.setString(2, course12);  
			            st.setString(3, course13);  
			            st.setString(4, course14);  
			            st.setString(5, course15);  
			            st.setInt(6, studentid); 

			            int r = st.executeUpdate();
			            if (r > 0) {
			                System.out.println("Grades updated successfully.");
			            } else {
			                System.out.println("No student found with the provided StudentID.");
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        } 
			    
			 }
			 else if (key==5) {
			
			        PreparedStatement st = null; 
			        PreparedStatement st1 = null; 
			        PreparedStatement st2 = null; 

			        String query = "INSERT INTO Students (StudentID, Name, Department, Semester, Email) VALUES (?, ?, ?, ?, ?)";
			        String query1="INSERT INTO USERINFO (username,type) values (?,?)";
			        String query2="INSERT INTO RESULT (studentid) values (?);";

			        try {
			            con = DriverManager.getConnection(URL, usernamee, password1);
			            st = con.prepareStatement(query);
			            st1=con.prepareStatement(query1);
			            st2=con.prepareStatement(query2);
                        System.out.println("Assign a student id");
                        int studentid=sc.nextInt();
                        System.out.println("Enter the semester");
                        int semester=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the name");
                        String name=sc.nextLine(); 
                        System.out.println("Enter the department:");
                        String department=sc.nextLine(); 
                       
                        System.out.println("Enter the email:");
                        String email=sc.nextLine();
			            
			            st.setInt(1, studentid);
			            st.setString(2, name); 
			            st.setString(3, department); 
			            st.setInt(4, semester); 
			            st.setString(5, email); 
                        st1.setString(1, String.valueOf(studentid));
                        st1.setInt(2, 2);
                        st2.setInt(1,studentid );
                        
			            int r = st.executeUpdate(); 
			            st2.executeUpdate();
			            if (r > 0) {
			                System.out.println("Student added successfully.");
			            } else {
			                System.out.println("Failed to add student.");
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        } finally {
			            
			            try {
			                if (st != null) st.close(); 
			                if (con != null) con.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }
			 }
			 else {
				 System.out.println("Invalid Input!!");
			 }
			 taskAssigner(username1);
		    	}catch(InputMismatchException e) {
		    		System.out.println("Invalid Entry!!"+"   Try Again");
		    		 sc.nextLine();
		    		managestudent(username1);
		    	}
			 
			}
		    void assignCourse(String username1) {
				// TODO Auto-generated method stub
                try {
		        String query = "INSERT INTO PROFESSORCOURSE (ProfessorID, CourseID) VALUES (?, ?)";
                 Connection con=null;
		        try {
		        		con = DriverManager.getConnection(URL, usernamee, password1);
		             PreparedStatement st = con.prepareStatement(query) ;
                    System.out.println("Enter the proffesor id who you want to assign to course:");
                    int professorid=sc.nextInt();
                    System.out.println("Enter the course id you want to assign ");
                    int courseid=sc.nextInt();
		            
		            st.setInt(1, professorid);
		            st.setInt(2, courseid);

		            
		            int r= st.executeUpdate();
		            if (r > 0) {
		                System.out.println("Course assigned successfully.");
		            }
		        } catch (SQLException e) {
		        	System.out.println("some error in data!!");
		            e.printStackTrace();
		        }
		   	 taskAssigner(username1);
                }catch(InputMismatchException e) {
                	System.out.println("Invalid Entery!!");
                	sc.nextLine();
                	assignCourse(username1);
                }
			}

			 void complainquery(String username1) {
				 try {
				 System.out.println("Enter the key correspondance to task");
				 System.out.println("1: View the Query");
				 System.out.println("2: Update the status");
				 int key=sc.nextInt();
				 Connection con=null;
				 if(key==1) {
					  String query = "SELECT * FROM inquiry";
                      
				        try { 
				        	con = DriverManager.getConnection(URL, usernamee, password1);
				             Statement stmt = con.createStatement();
				             ResultSet rs = stmt.executeQuery(query);
				                System.out.println("+------------+-------------------------------------+------------+");
								System.out.println("| student ID | query                               | status     |");
								System.out.println("+------------+-------------------------------------+------------+");
						    						             
					            while (rs.next()) 
					            {
					                int studentID = rs.getInt("studentid");
					                String quer = rs.getString("quer");
					                String status = rs.getString("status");

					                System.out.printf("| %-10d | %-35s | %-10s |", studentID, quer, status);
					                System.out.println();
					            }

								System.out.println("+------------+-------------------------------------+------------+");
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				 }
				 else if(key==2) {

			        String query = "UPDATE inquiry SET status = 'resolved' WHERE studentid = ? AND quer = ?";
                     System.out.println("Enter the query which is resolved: ");
                     sc.nextLine();
                     String query1=sc.nextLine();
                     System.out.println("Enter the student id whose inquiry is resolved :");
                     int studentid=sc.nextInt();
			        try { 
			        	con = DriverManager.getConnection(URL, usernamee, password1);
			             PreparedStatement pst = con.prepareStatement(query);
			            pst.setInt(1, studentid);
			            pst.setString(2, query1);
			            int rowsAffected = pst.executeUpdate();
			            if (rowsAffected > 0) {
			                System.out.println("Query status updated to resolved.");
			            }
			            else {
			            	System.out.println("Qyery Updation unsuccessful");
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			   }
			   else {
				   System.out.println("Invalid Entry!!");
			   }
			   taskAssigner(username1);
				 }catch(InputMismatchException e) {
	                	System.out.println("Invalid Entery!!");
	                	 sc.nextLine(); 
	                	complainquery(username1);
	                } 
			}

}
