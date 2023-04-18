package main.account;

import main.enums.AccountStatus;

public abstract class Account {
	private String userName;
	private String password;
	private AccountStatus status;
	private Person person;

	public void resetPassword() {
		password = "";
	}

	public Account() {
	}

	public Account(String userName, String password, AccountStatus status, Person person) {
		super();
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.person = person;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
