package jp.co.sgkr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sgkr.bean.BuyProducts;
import jp.co.sgkr.bean.Cart;
import jp.co.sgkr.bean.Order_history;
import jp.co.sgkr.dao.Dao;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//個人注文履歴追記処理
		request.setCharacterEncoding("UTF-8");
		
		Dao dao = null;
		try {
			dao = new Dao("tstdsv03", "orcl1", "ora121", "ora121");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		//取得と初期化
		String[] product_id = request.getParameter("product_id").split(",", 0);
		String[] product_qua = request.getParameter("product_qua").split(",", 0);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(product_id)); // 新インスタンスを生成
		list.remove("");
		product_id = (String[]) list.toArray(new String[list.size()]);
		list = new ArrayList<String>(Arrays.asList(product_qua)); // 新インスタンスを生成
		list.remove("");
		product_qua = (String[]) list.toArray(new String[list.size()]);
		System.out.print(request.getParameter("product_id").split(",", 0)[1]+request.getParameter("product_qua").split(",", 0)[1]);
		ArrayList<BuyProducts> bps = new ArrayList<BuyProducts>();
		int i=0;
		for(String p_id:product_id){
			String p_qua = product_qua[i];
			BuyProducts bp = new BuyProducts(Integer.parseInt(p_id),Integer.parseInt(p_qua));
			bps.add(bp);
			i++;
		}
		String customer_id = request.getParameter("customer_id");
		int t_amount = Integer.parseInt(request.getParameter("total_amount"));

		//Insert(Order_history)注文IDはオートインクリメントのため除外
		dao.InsertO(bps,customer_id,t_amount);
		String dispPage = "";
		dispPage = "Result.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(dispPage);
		request.setAttribute("msg", "購入完了しました。");
		disp.forward(request, response);
	}
}