package demo;

public class CurrentAccount extends Account {
	private int overdraft;

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "CurrentAccount [overdraft=" + overdraft + "] - base " + super.toString();
	}
	
}
