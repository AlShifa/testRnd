package com.coreJ;

import java.sql.Date;

public class BookingRequest {
	
	String BookingId;
	Integer pickUpArea;
	Integer dropArea;
	Date pickUptime;
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
				+ pickUptime + "]";
	}
	public BookingRequest(String bookingId, Integer pickUpArea,
			Integer dropArea, Date pickUptime) {
		super();
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
	public Date getPickUptime() {
		return pickUptime;
	}
	public void setPickUptime(Date pickUptime) {
		this.pickUptime = pickUptime;
	}

}
