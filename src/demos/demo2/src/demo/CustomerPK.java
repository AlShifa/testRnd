package demo;

import java.io.Serializable;

public class CustomerPK implements Serializable {

	private String compName;
	private String agentName;
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
}
