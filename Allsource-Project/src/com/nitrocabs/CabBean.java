package com.nitrocabs;

public class CabBean implements Comparable<CabBean>{
	@Override
	public String toString() {
		return "CapBean [capId=" + capId + ", pickUpLocation=" + pickUpLocation
				+ ", status=" + status + "]";
	}
	String capId;
	Integer pickUpLocation;
	//String dropLocation;
	boolean status;// available for yes , and not available or busy for No
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capId == null) ? 0 : capId.hashCode());
		result = prime * result
				+ ((pickUpLocation == null) ? 0 : pickUpLocation.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabBean other = (CabBean) obj;
		if (capId == null) {
			if (other.capId != null)
				return false;
		} else if (!capId.equals(other.capId))
			return false;
		if (pickUpLocation == null) {
			if (other.pickUpLocation != null)
				return false;
		} else if (!pickUpLocation.equals(other.pickUpLocation))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	public String getCapId() {
		return capId;
	}
	public void setCapId(String capId) {
		this.capId = capId;
	}
	public Integer getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(Integer pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public CabBean(String capId, Integer pickUpLocation, boolean status) {
		this.capId = capId;
		this.pickUpLocation = pickUpLocation;
		this.status = status;
	}
	@Override
	public int compareTo(CabBean o) {
		// TODO Auto-generated method stub
		return this.pickUpLocation.compareTo(o.getPickUpLocation());
	}

}
