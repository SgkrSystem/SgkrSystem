package jp.co.sgkr.bean;

public class Customer {
	private int id;
	private String pass;
	private String name;
	public Customer(int id,String pass,String name) {
		this.setId(id);
		this.setPass(pass);
		this.setName(name);
	}
	/*
	 * setter
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 *getter 
	 */
	public int getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
}
