package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  abstract class Account {
	
	private String acno;
	private int balance;
	@Override
	public String toString() {
		return "Account [acno=" + acno + ", balance=" + balance + "]";
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
