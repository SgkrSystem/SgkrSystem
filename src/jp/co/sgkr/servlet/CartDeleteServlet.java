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

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Cart> cart =  (ArrayList<Cart>) session.getAttribute("Cart");
		ArrayList<Cart> new_cart = new ArrayList<Cart>();
		request.setCharacterEncoding("UTF-8");
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		for(Cart c:cart){
			if(c.getP_id() != p_id){
			new_cart.add(c);
			}
		}
		cart = new_cart;
		
		session.setMaxInactiveInterval(18000); //ÉZÉbÉVÉáÉìÇTéûä‘ï€éù
		session.setAttribute("Cart", cart);

		String dispPage = "cart.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		disp.forward(request, response);
	}

}
