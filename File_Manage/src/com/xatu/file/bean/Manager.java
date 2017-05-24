package com.xatu.file.bean;
/**
 * 管理员
 * @author zpp
 *
 */
public class Manager {

	private int manager_ID;
	private String manager_number;
	private String manager_password;
	private String manager_lastTime;
	private int manager_loginTime;

	public int getManager_ID() {
		return manager_ID;
	}

	public void setManager_ID(int manager_ID) {
		this.manager_ID = manager_ID;
	}

	public String getManager_number() {
		return manager_number;
	}

	public void setManager_number(String manager_number) {
		this.manager_number = manager_number;
	}

	public String getManager_password() {
		return manager_password;
	}

	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}

	public String getManager_lastTime() {
		return manager_lastTime;
	}

	public void setManager_lastTime(String manager_lastTime) {
		this.manager_lastTime = manager_lastTime;
	}

	public int getManager_loginTime() {
		return manager_loginTime;
	}

	public void setManager_loginTime(int manager_loginTime) {
		this.manager_loginTime = manager_loginTime;
	}

}
