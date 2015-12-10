package jp.co.sgkr.bean;

public class Product {
		private int p_id;
		private String p_name;
		private int c_id;
		private int stock;
		private int order_point;
		private int sell_q;
		private int buy_q;
		private int m_id;
		private int u_price;
		private String c_name;
		private String m_name;
		private String img_url;
		private String p_detail;



		public Product(int p_id,String p_name,int c_id,
				int stock,int sell_q,int buy_q,int m_id,int u_price,String c_name,String m_name,String img_url,String p_detail){
			this.setP_id(p_id);
			this.setP_name(p_name);
			this.setC_id(c_id);
			this.setStock(stock);
			this.setOrder_point(order_point);
			this.setSell_q(sell_q);
			this.setBuy_q(buy_q);
			this.setM_id(m_id);
			this.setU_price(u_price);
			this.setC_name(c_name);
			this.setM_name(m_name);
			this.setImg_url(img_url);
			this.setP_detail(p_detail);
		}
		

		/*
		 * setter
		 */
		public void setP_id(int p_id) {
			this.p_id = p_id;
		}
		public void setP_name(String p_name) {
			this.p_name = p_name;
		}
		public void setC_id(int c_id) {
			this.c_id = c_id;
		}
		public void setImg_url(String img_url) {
			this.img_url = img_url;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public void setOrder_point(int order_point) {
			this.order_point = order_point;
		}
		public void setSell_q(int sell_q) {
			this.sell_q = sell_q;
		}
		public void setBuy_q(int buy_q) {
			this.buy_q = buy_q;
		}
		public void setM_id(int m_id) {
			this.m_id = m_id;
		}
		public void setU_price(int u_price) {
			this.u_price = u_price;
		}


		public void setC_name(String c_name) {
			this.c_name = c_name;
		}

		public void setM_name(String m_name) {
			this.m_name = m_name;
		}
		
		public void setP_detail(String p_detail) {
			this.p_detail = p_detail;
		}
		
		/*
		 * getter
		 */
		public int getP_id(){
			return p_id;
		}
		public String getP_name(){
			return p_name;
		}
		public int getC_id(){
			return c_id;
		}
		public int getStock() {
			return stock;
		}
		public int getOrder_point() {
			return order_point;
		}
		public int getSell_q() {
			return sell_q;
		}
		public int getBuy_q() {
			return buy_q;
		}
		public int getM_id() {
			return m_id;
		}
		public int getU_price() {
			return u_price;
		}		
		public String getC_name() {
			return c_name;
		}
		public String getM_name() {
			return m_name;
		}
		public String getImg_url() {
			return img_url;
		}
		public String getP_detail() {
			return p_detail;
		}
}
