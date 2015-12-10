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
 * Servlet implementation class SyouhinServlet
 */
@WebServlet("/SyouhinServlet")
public class SyouhinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SyouhinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Maker> makers = new ArrayList<Maker>();
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		products = dao.SelectP();
		categories = dao.SelectC();
		makers = dao.SelectM();
		String dispPage = "zaiko_koubai.jsp";
		String []s = request.getHeader("referer").split("[/]");
		System.out.println(s[s.length-1]);
		if(s[s.length-1].equals("Index.jsp")){
			dispPage = "Syouhinitiran.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.setAttribute("makers", makers);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Product> products = new ArrayList<Product>();
		Dao dao = null;
		String msg = "";

		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (request.getParameter("searchwd").equals(null)
				|| request.getParameter("searchwd").isEmpty()) {
			products = dao.SelectP();
		} else {
			products = dao.SelectP_searchwd(request.getParameter("searchwd"));
		}
		String dispPage = "";
		if (products == null || products.isEmpty()) {
			dispPage = "Result.jsp";
			msg = "åüçıåãâ Ç™ÇOåèÇ≈Ç∑ÅB";
		} else {
			String[] s = request.getHeader("referer").split("[/]");
			dispPage = s[s.length - 1];
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", msg);
		request.setAttribute("products", products);
		disp.forward(request, response);
	}

}
