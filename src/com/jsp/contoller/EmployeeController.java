package com.jsp.contoller;

import java.util.List;
import java.util.Scanner;
import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

public class EmployeeController {
public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   EmployeeDao e = new EmployeeDao();
	 boolean f= true;
	   while(f) {
		   System.out.println("1.Save Employee Details\n2.Update Employee details\n3.Verify Employee Details using email and password\n4.Verify Employee Details using phone and password\n5.delete Employee Details\n6.Show all the Employee Details\n7.exit");
		   System.out.println("Enter The Option: ");
		   int option = sc.nextInt(); 
		   sc.nextLine();
	   
	   switch(option) {
	   case 1:{ System.out.println("Enter The Id");
		       int eid =sc.nextInt();
		       sc.nextLine();
		       System.out.println("Enter The Name");
			   String name= sc.nextLine();
			   System.out.println("Enter The Phone Number");
			   long phoneNo =sc.nextLong();
			   sc.nextLine();
			   System.out.println("Enter The email");
			   String email= sc.nextLine();
			   System.out.println("Enter The Password");
			   String password= sc.nextLine();
			   Employee emp = new Employee(eid,name,phoneNo,email,password);
			   e.saveEmployee(emp);
			   break;}
		   
	   case 2:
	   {
		   System.out.println("Update the Employee name: \n Employee phone: \n Employee email: \n Employee password: \n using id: \n");
			String name = sc.next();
			long phoneNo = sc.nextLong();
			String email = sc.next();
			String password = sc.next();
			int eid= sc.nextInt();
			Employee u=new Employee(eid,name,phoneNo,email,password);
			String message=e.updateEmployee(u);
			System.out.println(message);
			break;
	   }
	   case 3:
	   {
		   System.out.println("Enter email and Password");
		   String email =sc.nextLine();
		   String password =sc.nextLine();
		   Employee e1= e.VerifyEmployee(email, password);
		   if(e1!=null) {
			   System.out.println("name: "+e1.geteName());
			   System.out.println("phoneNo: "+e1.getPhoneNo());
			   System.out.println("id: "+e1.geteId());
		   }
		   else {
			   System.out.println("Not found");
		   }
		   break;
		   }
	   case 4:
	   {
		   System.out.println("Enter phoneNo and Password");
		   Long phoneNo =sc.nextLong();
		   sc.nextLine();
		   String password =sc.nextLine();
		   Employee e1= e.VerifyEmployee(phoneNo, password);
		   if(e1!=null) {
			   System.out.println("name: "+e1.geteName());
			   System.out.println("phoneNo: "+e1.getEmail());
			   System.out.println("id: "+e1.geteId());
		   }
		   else {
			   System.out.println("Not found");
		   }
		   break;
		   }
	   
	   case 5:{
		     System.out.println("Enter the Id");
		     int id =sc.nextInt();
		    Employee e1=e.deleteEmployee(id);
		   if(e1!=null) {
			   System.out.println("deleted successfully");
		   }
		   else {
			   System.out.println("wrong id");
		   }
		   break;
	   }
	   case 6:
		   {List<Employee> emp=e.findAll();
			if(emp.size()>0) {
				for(Employee u:emp) {
					System.out.println("user found successfully.......");
			    	System.out.println("User id: "+u.geteId());
		        	System.out.println("User name: "+u.geteName());
		        	System.out.println("User phone no: "+u.getPhoneNo());
		        	System.out.println("User email: "+u.getEmail());
		        	System.out.println("User password: "+u.getPassword());
		        	System.out.println("============================");
				}
			}else {
				System.err.println("No user present in database.......");
			}
			break;}
	   case 7:{
		   f = false;
			try {
				System.out.println(e.exit());
				sc.close();
				
			} catch (Exception r) {
				r.printStackTrace();
			}
	   }
		   default:
			   System.err.println("Invalid Option");
			   break;
	   }
}}
}
