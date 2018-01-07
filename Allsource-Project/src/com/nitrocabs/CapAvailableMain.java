package com.nitrocabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CapAvailableMain {
	static int cuttOffBookingTime = 30; // 15 min before and 30 min assume cutOff booking
										
	static TreeMap<CabBean, Integer> cabAvailableAtcutOffTime = BookingReqAndCabData.getCabBean();
	static List<BookingRequest> bookingReq= BookingReqAndCabData.getBookingReq();	

	public static void main(String[] args) {
		
		//process start every half an hour
		BookingRequest pickReq = getBookingReqsuest(bookingReq);
		CabBean cabBean = BussinessLogic.availCapForRequest(cabAvailableAtcutOffTime, pickReq	);
		if(cabBean!=null){
			//set cabBean 
			pickReq.setCabId(cabBean.getCapId());	
			cabBean.setStatus(false);//it's picked up
			System.out.println(pickReq);	
		}
		

		
	}

	static BookingRequest getBookingReqsuest(List<BookingRequest> list) {
		// setup Request every half an hours 
		//here logic to fetch every half an hour 
		System.out.println(list.get(4));
		return list.get(4);
	}

}
