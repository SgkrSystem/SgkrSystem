package jp.co.sgkr.bean;

import java.util.Date;

public class C_order_history {
	private int c_orderid;
	private int c_id;
	private Date orderday;
	private int payment;
	private int approval;
	private int t_amount;
	public C_order_history(int c_orderid,int c_id,Date orderday,
			int payment,int approval,int t_amount) {
		this.setC_orderid(c_orderid);
		this.setC_id(c_id);
		this.setOrderday(orderday);
		this.setPayment(payment);
		this.setApproval(approval);
		this.setT_amount(t_amount);
	}
	
	/*
	 * setter
	 */
	public void setT_amount(int t_amount) {
		this.t_amount = t_amount;
	}
	public void setApproval(int approval) {
		this.approval = approval;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public void setOrderday(Date orderday) {
		this.orderday = orderday;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public void setC_orderid(int c_orderid) {
		this.c_orderid = c_orderid;
	}

	/*
	 * getter
	 */
	public int getC_orderid() {
		return c_orderid;
	}
	public int getC_id() {
		return c_id;
	}
	public Date getOrderday() {
		return orderday;
	}
	public int getPayment() {
		return payment;
	}
	public int getApproval() {
		return approval;
	}
	public int getT_amount() {
		return t_amount;
	}
}
