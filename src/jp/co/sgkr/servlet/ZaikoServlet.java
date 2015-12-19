package jp.co.sgkr.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sgkr.bean.Category;
import jp.co.sgkr.bean.Maker;
import jp.co.sgkr.bean.Product;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class ZaikoServlet
 */
@WebServlet("/ZaikoServlet")
public class ZaikoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Maker> makers = new ArrayList<Maker>();
		String P_id = request.getParameter("P_id");
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		products = dao.ProductP(P_id);
		categories = dao.SelectC();
		makers = dao.SelectM();
		
		String dispPage = "zaiko.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.setAttribute("makers", makers);
		disp.forward(request, response);
	}
}