package jp.co.sgkr.bean;

public class Maker {
	private int m_id;
	private String m_name;
	public Maker(int m_id,String m_name){
		this.setM_id(m_id);
		this.setM_name(m_name);
	}
	
	/*
	 * setter
	 */
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	
	/*
	 * getter
	 */
	public int getM_id() {
		return m_id;
	}
	public String getM_name() {
		return m_name;
	}
}
