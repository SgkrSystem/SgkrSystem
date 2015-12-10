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
 * Servlet implementation class ZaikoUpdateServret
 */
@WebServlet("/ZaikoUpdateServret")
public class ZaikoUpdateServret extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZaikoUpdateServret() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Category> categories = new ArrayList<Category>();
		ArrayList<Maker> makers = new ArrayList<Maker>();
		String msg = "";
		Product product = new Product(Integer.parseInt(
				request.getParameter("P_id")),request.getParameter("P_name"),Integer.parseInt(request.getParameter("C_id"))
				,Integer.parseInt(request.getParameter("Stok")),  Integer.parseInt(request.getParameter("Sell_q")), Integer.parseInt(request.getParameter("Buy_q"))
				,Integer.parseInt(request.getParameter("M_id")),Integer.parseInt(request.getParameter("U_price")),request.getParameter("c_name"), request.getParameter("m_name"), request.getParameter("img_url"), request.getParameter("p_detail"));
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean b = dao.UpdateP(product);
		if(b){
			msg = "更新が完了しました";
		}else{
			msg = "データベース処理に失敗しました";
		}
		products = dao.ProductP(String.valueOf(product.getP_id()));
		categories = dao.SelectC();
		makers = dao.SelectM();
		String dispPage = "zaiko.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("products", products);
		request.setAttribute("categories", categories);
		request.setAttribute("makers", makers);
		request.setAttribute("msg", "更新完了");
		disp.forward(request, response);
	}
}