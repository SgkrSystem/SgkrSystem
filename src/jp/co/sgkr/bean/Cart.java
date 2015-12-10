package jp.co.sgkr.bean;

public class Cart {
	private int p_id;
	private String p_name;
	private int p_quantity;
	private int u_price;
	
	public Cart(int p_id, int p_quantity, String p_name, int u_price) {
		super();
		this.p_id = p_id;
		this.p_quantity = p_quantity;
		this.p_name = p_name;
		this.u_price = u_price;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getP_quantity() {
		return p_quantity;
	}
	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getU_price() {
		return u_price;
	}
	public void setU_price(int u_price) {
		this.u_price = u_price;
	}
}
