package jp.co.sgkr.bean;

public class Category {
	private int c_id;
	private String c_name;
	public Category(int c_id,String c_name) {
		this.setC_id(c_id);
		this.setC_name(c_name);
	}
	
	/*
	 * setter
	 */
	public void setC_name(String c_name) {
		this.c_name = c_name;
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
	public String getC_name() {
		return c_name;
	}

}
