package jp.co.sgkr.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sgkr.bean.Customer;
import jp.co.sgkr.bean.Product;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class IndividualcustomerRegistServlet
 */
@WebServlet("/IndividualcustomerRegistServlet")
public class IndividualcustomerRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualcustomerRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = String.valueOf(request.getParameter("name"));
		String passwd = request.getParameter("passwd");
		
		Customer c = new Customer(id, name, passwd);
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		dao.InsertCu(c);
		String dispPage = "";
		dispPage = "result.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", "“o˜^Š®—¹");
		disp.forward(request, response);
	}

}
