package jp.co.sgkr.bean;

import java.util.Date;

public class Order_history {
	private int o_id;
	private int id;
	private Date o_day;
	private String address;
	private int card_num;
	private int phone_num;
	private int t_amount;
	public Order_history(int o_id,int id,Date o_day,String address,
			int card_num,int phone_num,int t_amount) {
		this.setO_id(o_id);
		this.setId(id);
		this.setO_day(o_day);
		this.setAddress(address);
		this.setCard_num(card_num);
		this.setPhone_num(phone_num);
		this.setT_amount(t_amount);
	}
	/*
	 * setter
	 */
	public void setT_amount(int t_amount) {
		this.t_amount = t_amount;
	}
	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}
	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setO_day(Date o_day) {
		this.o_day = o_day;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	
	/*
	 *getter 
	 */
	public int getO_id() {
		return o_id;
	}
	public int getId() {
		return id;
	}
	public Date getO_day() {
		return o_day;
	}
	public String getAddress() {
		return address;
	}
	public int getCard_num() {
		return card_num;
	}
	public int getPhone_num() {
		return phone_num;
	}
	public int getT_amount() {
		return t_amount;
	}

}
