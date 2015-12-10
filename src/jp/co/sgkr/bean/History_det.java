package jp.co.sgkr.bean;

public class History_det {
	private int o_d_id;
	private int o_id;
	private int cmp_id;
	private int qua;
	private int u_price;
	private String p_name;
	private String c_name;
	private String m_name;
	public History_det(int o_d_id,int o_id,int cmp_id,int qua,
			int u_price,String p_name,String c_name,String m_name) {
		this.setO_d_id(o_d_id);
		this.setO_id(o_id);
		this.setCmp_id(cmp_id);
		this.setQua(qua);
		this.setU_price(u_price);
		this.setP_name(p_name);
		this.setC_name(c_name);
		this.setM_name(m_name);
	}
	/*
	 * setter
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public void setU_price(int u_price) {
		this.u_price = u_price;
	}
	public void setQua(int qua) {
		this.qua = qua;
	}
	public void setCmp_id(int cmp_id) {
		this.cmp_id = cmp_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public void setO_d_id(int o_d_id) {
		this.o_d_id = o_d_id;
	}
	
	/*
	 * getter
	 */
	public int getO_d_id() {
		return o_d_id;
	}
	public int getO_id() {
		return o_id;
	}
	public int getCmp_id() {
		return cmp_id;
	}
	public int getQua() {
		return qua;
	}
	public int getU_price() {
		return u_price;
	}
	public String getP_name() {
		return p_name;
	}
	public String getC_name() {
		return c_name;
	}
	public String getM_name() {
		return m_name;
	}
}
