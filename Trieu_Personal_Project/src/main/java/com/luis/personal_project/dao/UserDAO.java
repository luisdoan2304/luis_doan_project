package com.luis.personal_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.luis.personal_project.entity.User;

public class UserDAO {
	
	public boolean validateUser(User user) {
		
		boolean isLogined = false;
		
		//connect DB
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			
			//execute SQL get username and password
			sql = "select * from user where user_name = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				isLogined = true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isLogined;
	}
}
