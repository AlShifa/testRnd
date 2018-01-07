package com.nitrocabs;

import java.sql.Date;

public class BookingRequest implements Comparable<BookingRequest> {
	
	String BookingId;
	Integer pickUpArea;
	Integer dropArea;
	Integer pickUptime; //0 to 24
	String cabId;
	public String getCabId() {
		return cabId;
	}
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}
	public String getBookingId() {
		return BookingId;
	}
	public void setBookingId(String bookingId) {
		BookingId = bookingId;
	}
	public Integer getPickUpArea() {
		return pickUpArea;
	}
	@Override
	public String toString() {
		return "BookingRequest [BookingId=" + BookingId + ", pickUpArea="
				+ pickUpArea + ", dropArea=" + dropArea + ", pickUptime="
				+ pickUptime + ", cabId=" + cabId + "]";
	}
	public BookingRequest(String bookingId, Integer pickUpArea,
			Integer dropArea, Integer pickUptime) {
		//super();
		BookingId = bookingId;
		this.pickUpArea = pickUpArea;
		this.dropArea = dropArea;
		this.pickUptime = pickUptime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((BookingId == null) ? 0 : BookingId.hashCode());
		result = prime * result
				+ ((dropArea == null) ? 0 : dropArea.hashCode());
		result = prime * result
				+ ((pickUpArea == null) ? 0 : pickUpArea.hashCode());
		result = prime * result
				+ ((pickUptime == null) ? 0 : pickUptime.hashCode());
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
		BookingRequest other = (BookingRequest) obj;
		if (BookingId == null) {
			if (other.BookingId != null)
				return false;
		} else if (!BookingId.equals(other.BookingId))
			return false;
		if (dropArea == null) {
			if (other.dropArea != null)
				return false;
		} else if (!dropArea.equals(other.dropArea))
			return false;
		if (pickUpArea == null) {
			if (other.pickUpArea != null)
				return false;
		} else if (!pickUpArea.equals(other.pickUpArea))
			return false;
		if (pickUptime == null) {
			if (other.pickUptime != null)
				return false;
		} else if (!pickUptime.equals(other.pickUptime))
			return false;
		return true;
	}
	public void setPickUpArea(Integer pickUpArea) {
		this.pickUpArea = pickUpArea;
	}
	public Integer getDropArea() {
		return dropArea;
	}
	public void setDropArea(Integer dropArea) {
		this.dropArea = dropArea;
	}
	public Integer getPickUptime() {
		return pickUptime;
	}
	public void setPickUptime(Integer pickUptime) {
		this.pickUptime = pickUptime;
	}
	@Override
	public int compareTo(BookingRequest o) {			
		return this.pickUpArea.compareTo(o.getPickUpArea());
	}

}
