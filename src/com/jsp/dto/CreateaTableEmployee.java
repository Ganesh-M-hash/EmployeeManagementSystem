package com.jsp.dto;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class CreateaTableEmployee {
public static void main(String[] args) {
	Connection con= null;
	Properties p =new Properties();
	FileInputStream fis =null;
	Statement stmt=null;
	File f= null;
	String qry="create table employee(id int not null, name varchar(45) not null, phone bigint(20) not null unique, email varchar(45) not null unique, password varchar(45) not null, primary key(id))";
	try {

		fis = new FileInputStream("src\\jdbc.properties");
		p.load(fis);
		Class.forName(p.getProperty("driverClass"));
		con = DriverManager.getConnection(p.getProperty("url"), p);
		stmt = con.createStatement();
		stmt.execute(qry);
		System.out.println("employee table created");
	}
	catch(Exception e) {
            System.err.println("Table Creation Failed!!!!");
	}
}
}
