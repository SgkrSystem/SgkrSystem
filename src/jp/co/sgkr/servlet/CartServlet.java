package jp.co.sgkr.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sgkr.bean.Cart;
import jp.co.sgkr.bean.Product;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dispPage = "";
		String msg = "";
		HttpSession session = request.getSession(true);
		if (session.getAttribute("ID") == null) {
			dispPage = "Result.jsp";
			msg = "カート機能を使うにはログインしてください";
		} else {
			ArrayList<Cart> cart = null;
			if (request.getSession(true) != null) {
				cart = (ArrayList<Cart>) session.getAttribute("Cart");
			}
			request.setCharacterEncoding("UTF-8");
			int p_id = Integer.parseInt(request.getParameter("ID"));
			int p_quantity = Integer.parseInt(request.getParameter("P_QUA"));
			String p_name = request.getParameter("P_NAME");
			int u_price = Integer.parseInt(request.getParameter("PRICE"));

			cart.add(new Cart(p_id, p_quantity, p_name, u_price));
			session.setMaxInactiveInterval(18000); // セッション５時間保持
			session.setAttribute("Cart", cart);

			dispPage = "cart.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", msg);
		disp.forward(request, response);
	}
}
