package jp.co.sgkr.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String msg = "";
		
		if(ID.equals(null)||ID.isEmpty()){
			msg += "IDが未入力です。";
		}
		if(passwd.equals(null)||passwd.isEmpty()){
			msg += "\nパスワードが未入力です。";
		}
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		HttpSession session = request.getSession(true);
		boolean b = dao.Check_Login(ID, passwd);
		String dispPage = "";
		if(b){
			msg +="\nログインに失敗しました。";
			dispPage = "Result.jsp";
		}else{
			msg +="\nログインに成功しました。";
			session.setAttribute("ID", ID);
			dispPage = "Index.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", msg);
		disp.forward(request, response);
	}

}
