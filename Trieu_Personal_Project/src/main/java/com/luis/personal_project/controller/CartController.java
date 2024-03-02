package com.luis.personal_project.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.luis.personal_project.dao.ProductDAO;
import com.luis.personal_project.entity.Cart;
import com.luis.personal_project.entity.Product;
import com.luis.personal_project.model.ProductInCart;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = null;
		productId = request.getParameter("productId");
		int productIdInt = 0;
		Cart cart = null;
		ProductDAO productDAO = null;
		Product product = null;

		productIdInt = Integer.parseInt(productId);
		productDAO = new ProductDAO();
		product = productDAO.getProductById(productIdInt);

		HttpSession session = request.getSession();
		ProductInCart productInCart = null;
		productInCart = new ProductInCart(product.getId(), product.getName(), product.getPrice(), product.getPrice(), 1);

		if (session.getAttribute("cart") == null) { // when there is no cart in session

			cart = new Cart();

			cart.setItems(new HashSet<ProductInCart>()); // create Set<ProductInCart> items = new
															// HashSet<ProductInCart>()

		} else {

			cart = (Cart) session.getAttribute("cart");// get cart

		}



		if (cart.getItems().contains(productInCart)) { // check if an item is existed in cart yet

			for (ProductInCart item : cart.getItems()) { // compare item with items in cart

				if (item.getId() == productInCart.getId()) {// if item is in cart already

					productInCart.setQuantity(item.getQuantity() + 1);

					productInCart.setSubTotal(productInCart.getQuantity() * productInCart.getPrice());

				}
			}
			cart.getItems().remove(productInCart);

			cart.getItems().add(productInCart);

		} else {//if an item is not existed in cart yet
			
			cart.getItems().add(productInCart);
			
		}
		
		cart.setTotal(cart.getTotal() + product.getPrice());// sum of subTotal of each product

		session.setAttribute("cart", cart);

		response.sendRedirect("home");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
