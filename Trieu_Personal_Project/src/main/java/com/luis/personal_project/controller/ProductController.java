package com.luis.personal_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luis.personal_project.dao.ProductDAO;
import com.luis.personal_project.entity.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = null;
		int productIdInt = 0;
		ProductDAO productDAO = null;
		Product product = null;
		RequestDispatcher rd = null;
				
		productId  = request.getParameter("productId");
		productDAO = new ProductDAO();
		productIdInt = Integer.parseInt(productId);
		product = productDAO.getProductById(productIdInt);
		
		rd = request.getRequestDispatcher("/single-product.jsp");
		request.setAttribute("product", product);
		rd.forward(request, response);
		
		
		
		
		
		//response.sendRedirect(request.getContextPath() + "/single-product.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
