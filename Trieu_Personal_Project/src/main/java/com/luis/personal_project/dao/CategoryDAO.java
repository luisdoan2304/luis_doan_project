package com.luis.personal_project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luis.personal_project.entity.Category;

public class CategoryDAO {

	
	public List<Category>getCategoryList(){
		
		//connect to DB
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		Statement stmt = null;
		Category category = null;
		List<Category> categoryList = null;
		
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			sql = "select * from product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			categoryList = new ArrayList<Category>();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String type = rs.getString("type");
				
				category = new Category(id, type);
				
				categoryList.add(category);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
		return categoryList;
				
	}
}
