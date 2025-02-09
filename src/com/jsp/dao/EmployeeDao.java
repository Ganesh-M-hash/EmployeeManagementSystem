package com.jsp.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.jsp.dto.Employee;

public class EmployeeDao {
     Connection con =null;
     PreparedStatement pstmt=null;
     ResultSet rs =null;
     {
    	 FileInputStream fis =null;
         Properties p = new Properties();
    	 
         try {
        	 
             
        	 fis = new FileInputStream("src//jdbc.properties");
        	 p.load(fis);
        	 con =DriverManager.getConnection(p.getProperty("url"),p);
             System.out.println("Database Connected Successfully!!!!");
         }catch(Exception e) {
        	 System.err.println("Database Not connected!!!!");
         }
         finally {
        	 if(fis!=null) {
          		try {
          			fis.close();
          		}catch(IOException e){
          			e.printStackTrace();
          		}
          			
          		}
          	 }
        	 }
         
     
      public void saveEmployee(Employee e)  {
    	  String qry ="insert into employee.employee values(?,?,?,?,?);";
    	  try {
			pstmt =con.prepareStatement(qry);
			pstmt.setInt(1,e.geteId());
			pstmt.setString(2, e.geteName());
			pstmt.setLong(3,e.getPhoneNo());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getPassword());
			
			pstmt.executeUpdate();
            System.out.println("Saved The Details!!!");

		} catch (SQLException r) {
                   System.out.println("Unable TO Save The Details!!!");
		}
    	  
      }
      public String updateEmployee(Employee e) {
    	  String qry = "update Employee set name=?, phone=?, email=?, password=?  where id=?";
  		try {
  			pstmt = con.prepareStatement(qry);
  			pstmt.setString(1, e.geteName());
  			pstmt.setLong(2, e.getPhoneNo());
  			pstmt.setString(3, e.getEmail());
  			pstmt.setString(4, e.getPassword());
  			pstmt.setInt(5, e.geteId());
  			pstmt.executeUpdate();
  			return "Employee values updated successfully.......";
  		} catch (Exception r) {
  			return "unable to update user values........";
  		}
      }
      public Employee deleteEmployee(int id) {
    	  String qry = "delete from Employee where id=?";
  		try {
  			pstmt = con.prepareStatement(qry);
  			pstmt.setInt(1, id);
  			int r = pstmt.executeUpdate();
  			Employee u=new Employee();
  			if (r == 1) {
  				return u;
  			}else {
  				return null;
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  			return null;
  		}
      }
      public Employee VerifyEmployee(String email, String password) {
  		String qry = "select * from employee where email=? and password=?";
  		try {
  			pstmt = con.prepareStatement(qry);
  			pstmt.setString(1, email);
  			pstmt.setString(2, password);
  			rs = pstmt.executeQuery();
  			Employee u=new Employee();

  			   if (rs.next()) {
  					u.seteId(rs.getInt("id"));
  					u.seteName(rs.getString("name"));
  					u.setPhoneNo(rs.getLong("phone"));
  					return u;
  				} else {
  					return null;
  				}
  				
  			} catch (Exception e) {
  				e.printStackTrace();
  				return null;
  		}
  	}
      public Employee VerifyEmployee(Long phoneNo, String password) {
    		String qry = "select * from employee where phone=? and password=?";
    		try {
    			pstmt = con.prepareStatement(qry);
    			pstmt.setLong(1, phoneNo);
    			pstmt.setString(2, password);
    			rs = pstmt.executeQuery();
    			Employee u=new Employee();

    			   if (rs.next()) {
    					u.seteId(rs.getInt("id"));
    					u.seteName(rs.getString("name"));
    					u.setEmail(rs.getString("email"));
    					return u;
    				} else {
    					return null;
    				}
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    				return null;
    		}
    	}
      public List<Employee> findAll() {
  		String qry="select * from employee";
  		List<Employee> emp=new ArrayList<>();
  		try {
  			pstmt=con.prepareStatement(qry);
  			rs=pstmt.executeQuery();
  			while(rs.next()) {
  				Employee u=new Employee();
  				u.seteId(rs.getInt("id"));
  				u.seteName(rs.getString("name"));
  				u.setPhoneNo(rs.getLong("phone"));
  				u.setEmail(rs.getString("email"));
  				u.setPassword(rs.getString("password"));
  				emp.add(u);
  			}
  			return emp;
  		}catch(Exception e) {
  			e.printStackTrace();
  			return null;
  		}
  	}
      public String exit() throws Exception {

  		if (con != null)
  			con.close();
  		if (pstmt != null)
  			pstmt.close();
  		if (rs != null)
  			rs.close();

  		for (int i=0;i<8;i++) {
  			System.err.print("*");
  			Thread.sleep(500);
  		}

  		return "Application Closed.......!!!!!!";
  	}
     }
     
     

