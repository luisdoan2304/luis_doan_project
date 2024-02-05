package com.luis.personal_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.luis.personal_project.entity.Product;

public class ProductDAO {

	public List<Product> getLatestProductList() {

		List<Product> productList = new ArrayList<Product>();

		// connect DB MySQL
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;

		try {
			conn = MySQLConnUtils.getMySQLConnection();
			sql = "Select * from products where isNew = '1'";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				Float price = rs.getFloat("price");
				String image = rs.getString("image");
				boolean isNew = rs.getBoolean("isNew");

				Product product = new Product(id, name, price, image, isNew);
				productList.add(product);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;

	}

	public List<Product> getProductsByCategoryId(int categoryId) {

		// connect DB
		Connection conn = null;
		String sql = "";
		ResultSet rs = null;
		PreparedStatement preStmt = null;
		Product product = null;
		List<Product> productList = null;

		try {
			conn = MySQLConnUtils.getMySQLConnection();
			sql = "select * from products where product_category_id = ?" ;
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1,categoryId);
			rs = preStmt.executeQuery();
			productList = new ArrayList<Product>();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String image = rs.getString("image");
				
				product = new Product(id, name, price, image);
				productList.add(product);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	public Product getProductById(int productId){
		
		
		// connect DB MySQL
				Connection conn = null;
				String sql = "";
				ResultSet rs = null;
				PreparedStatement preStmt = null;
				Product product = null;

				try {
					conn = MySQLConnUtils.getMySQLConnection();
					sql = "Select * from products where id = ?";
					preStmt = conn.prepareStatement(sql);
					preStmt.setInt(1, productId);
					rs = preStmt.executeQuery();

					if (rs.next()) {

						int id = rs.getInt("id");
						String name = rs.getString("name");
						Float price = rs.getFloat("price");
						String image = rs.getString("image");						
						String description = rs.getString("description");

						product = new Product(id, name, price, image, description);
						
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return product;
		
	}

}
