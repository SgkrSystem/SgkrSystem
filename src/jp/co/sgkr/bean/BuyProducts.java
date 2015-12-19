package jp.co.sgkr.bean;

public class BuyProducts {
	private int p_id;
	private int p_qua;
	
	public BuyProducts(int p_id, int p_qua){
		this.setP_id(p_id);
		this.setP_qua(p_qua);
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_qua() {
		return p_qua;
	}

	public void setP_qua(int p_qua) {
		this.p_qua = p_qua;
	}
	
	
}
