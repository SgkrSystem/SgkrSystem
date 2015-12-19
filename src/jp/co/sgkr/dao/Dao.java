package jp.co.sgkr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp.DelegatingPreparedStatement;

import jp.co.sgkr.bean.*;

public class Dao {
	// Connection con =
	// DriverManager.getConnection("jdbc:oracle:thin:@tstdsv03:1521:orcl1","ora121","ora121");
	private String serverName;
	private String instanceName;
	private String userID;
	private String pass;

	public Dao(String serverName, String instanceName, String userID,
			String pass) throws ClassNotFoundException {
		this.serverName = serverName;
		this.instanceName = instanceName;
		this.userID = userID;
		this.pass = pass;

		Class.forName("oracle.jdbc.driver.OracleDriver");

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@" + serverName
				+ ":1521:" + instanceName, userID, pass);
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> SelectP() {
		ArrayList<Product> list = new ArrayList<Product>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from Product p left outer join category c on p.category_id = c.category_id left outer join maker m on p.maker_id = m.maker_id order by product_id");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int p_id = rs.getInt("product_id");
				String p_name = rs.getString("product_name");
				int c_id = rs.getInt("category_id");
				int stock = rs.getInt("stock_qua");
				int sell_q = rs.getInt("sell_qua");
				int buy_q = rs.getInt("buy_qua");
				int m_id = rs.getInt("maker_id");
				int u_price = rs.getInt("unit_price");
				String c_name = rs.getString("category_name");
				String m_name = rs.getString("maker_name");
				String img_url = rs.getString("img_url");
				String p_detail = rs.getString("p_detail");
				list.add(new Product(p_id, p_name, c_id, stock, sell_q, buy_q,
						m_id, u_price, c_name, m_name, img_url, p_detail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Product> SelectP_searchwd(String searchwd) {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("Select * from Product p left outer join category c on p.category_id = c.category_id left outer join maker m on p.maker_id = m.maker_id where p.product_name like {escape '\\'} ? {escape '\\'} order by product_id DESC;");
			ps.setString(1, searchwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int p_id = rs.getInt("product_id");
				String p_name = rs.getString("product_name");
				int c_id = rs.getInt("category_id");
				int stock = rs.getInt("stock_qua");
				int sell_q = rs.getInt("sell_qua");
				int buy_q = rs.getInt("buy_qua");
				int m_id = rs.getInt("maker_id");
				int u_price = rs.getInt("unit_price");
				String c_name = rs.getString("category_name");
				String m_name = rs.getString("maker_name");
				String img_url = rs.getString("img_url");
				String p_detail = rs.getString("p_detail");
				list.add(new Product(p_id, p_name, c_id, stock, sell_q, buy_q,
						m_id, u_price, c_name, m_name, img_url, p_detail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param Product
	 *            p
	 * @return boolean
	 */
	public boolean InsertP(Product p) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into Product values(?,?,?,?,?,?,?)");) {
			ps.setString(1, p.getP_name());
			ps.setInt(2, p.getC_id());
			ps.setInt(3, p.getStock());
			ps.setInt(4, p.getSell_q());
			ps.setInt(5, p.getBuy_q());
			ps.setInt(6, p.getM_id());
			ps.setInt(7, p.getU_price());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Product
	 *            p
	 * @return boolean
	 */
	public boolean UpdateP(Product p) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update Product Set product_name=?,category_id=?,stock_qua=?,sell_qua=?,buy_qua=?,maker_id=?,unit_price=? where product_id=?");) {
			ps.setString(1, p.getP_name());
			ps.setInt(2, p.getC_id());
			ps.setInt(3, p.getStock());
			ps.setInt(4, p.getSell_q());
			ps.setInt(5, p.getBuy_q());
			ps.setInt(6, p.getM_id());
			ps.setInt(7, p.getU_price());
			ps.setInt(8, p.getP_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Product
	 *            p
	 * @return boolean
	 */
	public boolean DeleteP(Product p) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from product where product_id = ?");) {
			ps.setInt(1, p.getP_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<Maker>
	 */
	public ArrayList<Maker> SelectM() {
		ArrayList<Maker> list = new ArrayList<Maker>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from maker order by maker_id");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int m_id = rs.getInt("maker_id");
				String m_name = rs.getString("maker_name");
				list.add(new Maker(m_id, m_name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param Maker
	 *            m
	 * @return boolean
	 */
	public boolean InsertM(Maker m) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into Maker values(?)");) {
			ps.setString(1, m.getM_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Maker
	 *            m
	 * @return boolean
	 */
	public boolean UpdateM(Maker m) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update Maker Set maker_name=? where maker_id = ?");) {
			ps.setInt(1, m.getM_id());
			ps.setString(2, m.getM_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Maker
	 *            m
	 * @return boolean
	 */
	public boolean DeleteM(Maker m) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from maker where maker_id = ?");) {
			ps.setInt(1, m.getM_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<Category>
	 */
	public ArrayList<Category> SelectC() {
		ArrayList<Category> list = new ArrayList<Category>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from category order by category_id desc");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int c_id = rs.getInt("category_id");
				String c_name = rs.getString("category_name");
				list.add(new Category(c_id, c_name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param Category
	 *            c
	 * @return boolean
	 */
	public boolean InsertC(Category c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into Category values(?)");) {
			ps.setString(1, c.getC_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Category
	 *            c
	 * @return boolean
	 */
	public boolean UpdateC(Category c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update Category Set category_name='?' where category_id = ?");) {
			ps.setInt(1, c.getC_id());
			ps.setString(2, c.getC_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Category
	 *            c
	 * @return boolean
	 */
	public boolean DeleteC(Category c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from maker where category_id = ?");) {
			ps.setInt(1, c.getC_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<Category>
	 */
	public ArrayList<Customer> SelectCu() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from Customer order by id");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String pass = rs.getString("passwd");
				String name = rs.getString("name");
				list.add(new Customer(id, pass, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param Customer
	 *            c
	 * @return boolean
	 */
	public boolean InsertCu(Customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into Customer values(?,?)");) {
			ps.setString(1, c.getPass());
			ps.setString(2, c.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Customer
	 *            c
	 * @return boolean
	 */
	public boolean UpdateCu(Customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update Category Set passwd=?,name=? where id=?");) {
			ps.setString(1, c.getPass());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Customer
	 *            c
	 * @return boolean
	 */
	public boolean DeleteCu(Customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from Customer where id = ?");) {
			ps.setInt(1, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<Order_history>
	 */
	public ArrayList<Order_history> SelectO() {
		ArrayList<Order_history> list = new ArrayList<Order_history>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from Order_history order by order_id");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int O_id = rs.getInt("order_id");
				int id = rs.getInt("id");
				Date O_day = rs.getDate("orderday");
				String address = rs.getString("address");
				int card_num = rs.getInt("card_number");
				int phone_num = rs.getInt("phone_number");
				int t_amount = rs.getInt("total_amount");
				list.add(new Order_history(O_id, id, O_day, address, card_num,
						phone_num, t_amount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param int id,Date o_day,String address, int card_num,int phone_num,int
	 *        t_amount Order_Historyに合わせると注文idが必要になる 注文idはwebからだとオートインクリメント
	 * @return boolean
	 */
	public boolean InsertO(ArrayList<BuyProducts> BuyProducts,String customer_id,int t_amount) {
		ResultSet rs = null;
		int order_id = -1;
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into Order_History(ORDER_ID,ORDER_DAY,TOTAL_AMOUNT,CUSTOMER_ID) SELECT NVL(MAX(ORDER_ID), 0) + 1,SYSDATE,?,? from Order_History");) {
			ps.setInt(1, t_amount);
			ps.setString(2, customer_id);
			ps.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement("Select max(order_id) from Order_History");
			rs = ps2.executeQuery();
			rs.next();
			order_id = rs.getInt("max(order_id)");

			for(BuyProducts bp:BuyProducts){
			PreparedStatement ps3 = con.prepareStatement("Insert into U_Order_Detail(U_ORDER_ID,ORDER_ID,PRODUCT_ID,P_QUA) SELECT NVL(MAX(u_ORDER_ID), 0) + 1,?,?,? from u_order_detail");
			ps3.setInt(1, order_id);
			ps3.setInt(2, bp.getP_id());
			ps3.setInt(3, bp.getP_qua());
			ps3.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Order_history
	 *            o
	 * @return boolean
	 */
	public boolean UpdateO(Order_history o) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update Order_history Set id=?,orderday=?,address=?,card_number=?,phone_number=?,total_amount=? where order_id=?");) {
			ps.setInt(1, o.getId());
			ps.setDate(2, (java.sql.Date) o.getO_day());
			ps.setString(3, o.getAddress());
			ps.setInt(4, o.getCard_num());
			ps.setInt(5, o.getPhone_num());
			ps.setInt(6, o.getT_amount());
			ps.setInt(7, o.getO_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param Order_history
	 *            o
	 * @return boolean
	 */
	public boolean DeleteO(Order_history o) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from Order_history where order_id = ?");) {
			ps.setInt(1, o.getO_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<C_customer>
	 */
	public ArrayList<C_customer> SelectC_cu() {
		ArrayList<C_customer> list = new ArrayList<C_customer>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from c_customer order by c_id;");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int c_id = rs.getInt("c_id");
				String pass = rs.getString("passwd");
				String c_name = rs.getString("c_name");
				String address = rs.getString("address");
				int phone_num = rs.getInt("phone_number");
				int fax_num = rs.getInt("fax_number");
				String e_mail = rs.getString("email");
				int credit_limit = rs.getInt("credit_limit");
				list.add(new C_customer(c_id, pass, c_name, address, phone_num,
						fax_num, e_mail, credit_limit));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param C_customer
	 *            c
	 * @return boolean
	 */
	public boolean InsertC_cu(C_customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into C_customer values(?,?,?,?,?,?,?)");) {
			ps.setString(1, c.getPass());
			ps.setString(2, c.getC_name());
			ps.setString(3, c.getAddress());
			ps.setInt(4, c.getPhone_num());
			ps.setInt(5, c.getFax_num());
			ps.setString(6, c.getE_mail());
			ps.setInt(7, c.getCredit_limit());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param C_customer
	 *            o
	 * @return boolean
	 */
	public boolean UpdateC_cu(C_customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update C_customer Set passwd=?,c_name=?,address=?,phone_number=?,fax_number=?,emial=?,credit_limit=?, where c_id=?");) {
			ps.setString(1, c.getPass());
			ps.setString(2, c.getC_name());
			ps.setString(3, c.getAddress());
			ps.setInt(4, c.getPhone_num());
			ps.setInt(5, c.getFax_num());
			ps.setString(6, c.getE_mail());
			ps.setInt(7, c.getCredit_limit());
			ps.setInt(8, c.getC_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param C_customer
	 *            c
	 * @return boolean
	 */
	public boolean DeleteC_cu(C_customer c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from C_customer where c_id = ?");) {
			ps.setInt(1, c.getC_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param null
	 * @return ArrayList<C_order_history>
	 */
	public ArrayList<C_order_history> SelectC_order() {
		ArrayList<C_order_history> list = new ArrayList<C_order_history>();
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Select * from c_order_history order by c_orderid;");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int c_orderid = rs.getInt("c_orderid");
				int c_id = rs.getInt("c_id");
				Date O_day = rs.getDate("orderday");
				int payment = rs.getInt("payment_ck");
				int approval = rs.getInt("approval_ck");
				int t_amount = rs.getInt("total_amount");
				list.add(new C_order_history(c_orderid, c_id, O_day, payment,
						approval, t_amount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param C_order_history
	 *            c
	 * @return boolean
	 */
	public boolean InsertC_order(C_order_history c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Insert into C_order_history values(?,?,?,?,?)");) {
			ps.setInt(1, c.getC_id());
			ps.setDate(2, (java.sql.Date) c.getOrderday());
			ps.setInt(3, c.getPayment());
			ps.setInt(4, c.getApproval());
			ps.setInt(5, c.getT_amount());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param C_order_day
	 *            c
	 * @return boolean
	 */
	public boolean UpdateC_order(C_order_history c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Update C_order_history Set c_id=?,orderday=?,payment_ck=?,approval_ck=?,total_amount=? where c_orderid=?");) {
			ps.setInt(1, c.getC_id());
			ps.setDate(2, (java.sql.Date) c.getOrderday());
			ps.setInt(3, c.getPayment());
			ps.setInt(4, c.getApproval());
			ps.setInt(5, c.getT_amount());
			ps.setInt(6, c.getC_orderid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param C_order_history
	 *            c
	 * @return boolean
	 */
	public boolean DeleteC_order(C_order_history c) {
		try (Connection con = getConnection();
				PreparedStatement ps = con
						.prepareStatement("Delete from C_order_history where c_orderid = ?");) {
			ps.setInt(1, c.getC_orderid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean Check_Login(String ID, String passwd) {
		try {
			Connection con = getConnection();
			ResultSet rs = null;
			PreparedStatement ps = con
					.prepareStatement("select * from S_user where s_name = ?");
			ps.setString(1, ID);
			rs = ps.executeQuery();
			rs.next();
			if (rs.getString("s_password").equals(passwd)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public ArrayList<Product> ProductP(String id) {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("Select * from Product t1 left outer join Category t2 on t1.CATEGORY_ID = t2.CATEGORY_ID left outer join MAKER t3 on t1.MAKER_ID = t3.MAKER_ID where t1.product_id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int p_id = rs.getInt("product_id");
				String p_name = rs.getString("product_name");
				int c_id = rs.getInt("category_id");
				int stock = rs.getInt("stock_qua");
				int sell_q = rs.getInt("sell_qua");
				int buy_q = rs.getInt("buy_qua");
				int m_id = rs.getInt("maker_id");
				int u_price = rs.getInt("unit_price");
				String c_name = rs.getString("category_name");
				String m_name = rs.getString("maker_name");
				String img_url = rs.getString("img_url");
				String p_detail = rs.getString("p_detail");
				ps.setString(1, id);
				list.add(new Product(p_id, p_name, c_id, stock, sell_q, buy_q,
						m_id, u_price, c_name, m_name, img_url, p_detail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public A_return accountselect(String ID, String passwd) {
		boolean b = true;
		String msg = "";
		A_return ar = new A_return(b, msg);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int i = 0;
		try {
			con = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "データベース接続に失敗しました";
			b = false;
		}
		try {
			ps = con.prepareStatement("Select count(*) from S_USER where S_USER_ID = ? and S_PASSWORD = ? group by S_USER_ID;");
			ps.setString(1, ID);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				i = rs.getInt("count(*)");
			}
			if (i != 1) {
				msg = "データベース処理に失敗しました";
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "データベース接続に失敗しました";
			b = false;
		}
		return ar;
	}
}
