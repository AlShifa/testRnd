package demo;

public class SavingAccount extends Account{
	private int minbalance;
	private int intRate;
	public int getMinbalance() {
		return minbalance;
	}
	public void setMinbalance(int minbalance) {
		this.minbalance = minbalance;
	}
	public int getIntRate() {
		return intRate;
	}
	public void setIntRate(int intRate) {
		this.intRate = intRate;
	}
	@Override
	public String toString() {
		return "SavingAccount [minbalance=" + minbalance + ", intRate="
				+ intRate + "]   - " + super.toString();
	}
	
	

	

}
