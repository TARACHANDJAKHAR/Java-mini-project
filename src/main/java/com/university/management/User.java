package com.university.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class User {
    String email;
    String username;
    Scanner sc = new Scanner(System.in);

    void login(String x, int type) {
        try {
            System.out.println("If you want to change your password : enter 1 or to continue without changing password : Enter 0");
            int count = sc.nextInt();

            if (count == 1) {
                System.out.println("Enter your new password");
                String updatedpassword = sc.next();
                
                String query = "update userinfo set password=? ,type=? where username=?";
                try (Connection con = DatabaseUtil.getConnection();
                     PreparedStatement st = con.prepareStatement(query)) {
                    
                    st.setString(1, updatedpassword);
                    st.setInt(2, type);
                    st.setString(3, x);
                    int row = st.executeUpdate();
                    
                    if (row > 0) {
                        System.out.println("Your password updated successfully!!");
                    } else {
                        System.out.println("Update failed");
                    }
                } catch (SQLException e) {
                    System.out.println("Database Error: " + e.getMessage());
                }
            } else if (count == 0) {
                System.out.println("Enter the password : ");
                String y = sc.next(); 
                
                String query = "select count(*) from userinfo where username= ? and password= ? and type=?";
                try (Connection con = DatabaseUtil.getConnection();
                     PreparedStatement st = con.prepareStatement(query)) {
                    
                    st.setString(1, x);
                    st.setString(2, y);
                    st.setInt(3, type);
                    
                    try (ResultSet rs = st.executeQuery()) {
                        int res = 0;
                        if (rs.next()) {
                            res = rs.getInt(1);
                        }
                        if (res == 0) {
                            System.out.println("Invalid Username or password\n");
                            System.out.println("wanted to try again:\n 1 for try again or 0 for exit the application");
                            int z = sc.nextInt();
                            if (z == 1) {
                                System.out.println("Enter the Username:");
                                x = sc.next();
                                login(x, type);
                            } else {
                                System.exit(0);
                            }
                        } else {
                            System.out.println("Login successfully\n");
                            this.username = x;
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Database Error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid Entry!!!");
                login(x, type);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Entry!!");
            System.out.println("Enter the Username:");
            sc.nextLine(); // Clear buffer
            x = sc.next();
            login(x, type);
        }
    }

    void logout() {
        System.out.println("Thank You for using the application !!");
        MainManager.main(null);
        System.exit(0);
    }
     
    abstract void taskAssigner(String x);
}
