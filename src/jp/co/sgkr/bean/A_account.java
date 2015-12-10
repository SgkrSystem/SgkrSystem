package jp.co.sgkr.bean;

public class A_account {
	private String accountId;
	private String password;
	private String nickname;
	
	
	
	public A_account(String accountId, String password, String nickname) {
		super();
		this.accountId = accountId;
		this.password = password;
		this.nickname = nickname;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccount(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

}
