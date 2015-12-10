package jp.co.sgkr.bean;

public class A_return {
	private boolean err;
	private String errMsg;
	public A_return(boolean err, String errMsg) {
		super();
		this.err = err;
		this.errMsg = errMsg;
	}
	public boolean isErr() {
		return err;
	}
	public void setErr(boolean err) {
		this.err = err;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	

}
