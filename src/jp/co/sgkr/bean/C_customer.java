package jp.co.sgkr.bean;

public class C_customer {
	private int c_id;
	private String pass;
	private String c_name;
	private String address;
	private int phone_num;
	private int fax_num;
	private String e_mail;
	private int credit_limit;
	public C_customer(int c_id,String pass,String c_name,String address,
			int phone_num,int fax_num,String e_mail,int credit_limit) {
		this.setC_id(c_id);
		this.setPass(pass);
		this.setC_name(c_name);
		this.setAddress(address);
		this.setPhone_num(phone_num);
		this.setFax_num(fax_num);
		this.setE_mail(e_mail);
		this.setCredit_limit(credit_limit);
	}
	/*
	 * setter
	 */
	public void setCredit_limit(int credit_limit) {
		this.credit_limit = credit_limit;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public void setFax_num(int fax_num) {
		this.fax_num = fax_num;
	}
	public void setPhone_num(int phone_num) {
		this.phone_num = phone_num;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	/*
	 * getter
	 */
	public int getC_id() {
		return c_id;
	}
	public String getPass() {
		return pass;
	}
	public String getC_name() {
		return c_name;
	}
	public String getAddress() {
		return address;
	}
	public int getPhone_num() {
		return phone_num;
	}
	public int getFax_num() {
		return fax_num;
	}
	public String getE_mail() {
		return e_mail;
	}
	public int getCredit_limit() {
		return credit_limit;
	}
}
