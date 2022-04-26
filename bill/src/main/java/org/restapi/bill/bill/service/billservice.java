package org.restapi.bill.bill.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.restapi.bill.bill.model.billmodel;


public class billservice {
	
	Connection con;
	
	public billservice(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/users");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
	
	public billmodel insertUser(billmodel user) {
		String insert = "insert into bill(name, unit) values(?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUnit());

			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return user;
		
	}
	
	public ArrayList<billmodel> getUser() throws SQLException{
		
		ArrayList<billmodel> data = new ArrayList<billmodel>();
		
		String select = "select * from bill";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			billmodel model = new billmodel();
			
			model.setName(rs.getString("name"));// column name
			model.setUnit(rs.getString("unit"));
			
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	public ArrayList<billmodel> getUserById(int id) throws SQLException{
		
		ArrayList<billmodel> data = new ArrayList<billmodel>();
		String select = "select * from bill where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			billmodel model = new billmodel();
			
			model.setName(rs.getString("name"));// column name
			model.setUnit(rs.getString("unit"));

			data.add(model);		
		}		
		return data;	
	}
	
	public billmodel updatetUser(billmodel user) {
		 
		 String insert = "update bill  set name=? , unit=?  where id =?";
			
			try {
				PreparedStatement ps = con.prepareStatement(insert);
				ps.setString(1, user.getName());
				ps.setString(2, user.getUnit());
				ps.setInt(3, user.getId());
				
				ps.executeUpdate();
			}catch(Exception e) {
				System.out.println(e +"data insert unsuccess.");	
			}
			
			return user;
			
		}
	
	public int deletetUser(int id) {
		String insert = "delete from bill where id =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}

}
