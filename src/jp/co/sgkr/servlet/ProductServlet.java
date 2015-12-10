package jp.co.sgkr.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sgkr.bean.Product;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String product_id = request.getParameter("ID");
		ArrayList<Product> products = new ArrayList<Product>();
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		products = dao.ProductP(product_id);
		String dispPage = "product.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("products", products);
		disp.forward(request, response);
	}
}
