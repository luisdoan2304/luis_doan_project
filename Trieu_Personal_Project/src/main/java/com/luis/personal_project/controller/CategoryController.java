package com.luis.personal_project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.personal_project.dao.CategoryDAO;
import com.luis.personal_project.dao.ProductDAO;
import com.luis.personal_project.entity.Category;
import com.luis.personal_project.entity.Product;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("categoryList") ) {
			
			getCategoryList(request, response);
			
		} else if(action.equals("productByCategoryId")) {
			
			getProductListByCategoryId(request, response);
		}
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void getCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryDAO categoryDAO = null;
		RequestDispatcher rd = null;
		List<Category> categoryList = null;
		
		categoryDAO = new CategoryDAO();
		categoryList = categoryDAO.getCategoryList();
		
		rd = request.getRequestDispatcher("/category.jsp");
		request.setAttribute("categoryList", categoryList);
		rd.forward(request, response);
	}

	
	protected void getProductListByCategoryId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryId = null;
		int categoryIdInt = 0;
		
		ProductDAO productDAO = null;
		List<Product> productListByCategoryId = null;
		RequestDispatcher rd = null;
				
		productDAO = new ProductDAO();
		categoryId = request.getParameter("categoryId");
		categoryIdInt = Integer.parseInt(categoryId);
		productListByCategoryId = productDAO.getProductsByCategoryId(categoryIdInt);
		
		CategoryDAO categoryDAO = null;
		List<Category> categoryList = null;
		
		categoryDAO = new CategoryDAO();
		categoryList = categoryDAO.getCategoryList();
		
		rd = request.getRequestDispatcher("/category.jsp");
		request.setAttribute("productListByCategoryId", productListByCategoryId);
		request.setAttribute("categoryList", categoryList);
		rd.forward(request, response);
		
		
		
	}
}
