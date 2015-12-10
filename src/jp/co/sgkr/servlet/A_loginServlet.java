package jp.co.sgkr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import jp.co.sgkr.bean.A_return;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class C_loginServlet
 */
@WebServlet("/C_loginServlet")
public class A_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean err = false;
		String errMsg ="";
		
		request.setCharacterEncoding("UTF-8");
		
		if((request.getParameter("ID") != null) || (!request.getParameter("ID").isEmpty()
				|| request.getParameter("Passwd") != null) || (!request.getParameter("Passwd").isEmpty()))
		{
			
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String accountId = request.getParameter("ID");
		String password = request.getParameter("Passwd");
		A_return ar = dao.accountselect(accountId,password);
		err = ar.isErr();
		if(err == true){
			errMsg="IDとパスワードが一致しないか、登録されていません。";
			
		}else{
			
			//セッションにIDを保存させる
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(36000);
			session.setAttribute("accountId",accountId);
		}
				
		}else{
			err=true;
			errMsg="IDかパスワードが入力されていません。";
		}
		
		RequestDispatcher disp;
		
		if(err = true)
		{
			disp = request.getRequestDispatcher("Result.jsp");
			request.setAttribute("errMsg", errMsg);
		}else{
			disp = request.getRequestDispatcher("WEB-INF/sgkrAdmin.jsp");
		}
		disp.forward(request,response);
	}

}
