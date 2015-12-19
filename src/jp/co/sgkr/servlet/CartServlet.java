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

		int p_id = 0;
		int p_quantity = 0;
		String p_name = "";
		int u_price = 0;

		HttpSession session = request.getSession(true);
		if (session.getAttribute("ID") == null) {
			dispPage = "Result.jsp";
			msg = "カート機能を使うにはログインしてください";
		} else {
			ArrayList<Cart> cart = null;
			if (session.getAttribute("Cart") != null) {
				cart = (ArrayList<Cart>) session.getAttribute("Cart");
			} else {
				cart = new ArrayList<Cart>();
			}
			request.setCharacterEncoding("UTF-8");
			ArrayList<Cart> new_cart = new ArrayList<Cart>();
			boolean flg = false;
			try {
				for (Cart c : cart) {
					if (c.getP_id() == Integer.parseInt(request
							.getParameter("P_ID"))) {
						new_cart.add(new Cart(c.getP_id(), c.getP_quantity()
								+ Integer.parseInt(request
										.getParameter("P_QUA")), c.getP_name(),
								c.getU_price()));
						flg = true;
					} else {
						new_cart.add(c);
					}
				}
				if (flg == false) {
					p_id = Integer.parseInt(request.getParameter("P_ID"));
					p_quantity = Integer.parseInt(request.getParameter("P_QUA"));
					p_name = request.getParameter("P_NAME");
					u_price = Integer.parseInt(request.getParameter("PRICE"));
					new_cart.add(new Cart(p_id, p_quantity, p_name, u_price));
				}
				session.setMaxInactiveInterval(18000); // セッション５時間保持
				session.setAttribute("Cart", new_cart);
				dispPage = "cart.jsp";
			} catch (NumberFormatException e) {
				e.printStackTrace();
				dispPage = "Result.jsp";
				msg = "購入数に数字以外を入力しないでください";
			}
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", msg);
		disp.forward(request, response);
	}
}
