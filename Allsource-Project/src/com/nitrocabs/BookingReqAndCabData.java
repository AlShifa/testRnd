package com.nitrocabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BookingReqAndCabData {
	
	static TreeMap<CabBean, Integer> cabAvailableAtcutOffTime;
	static List<BookingRequest> bookingReq;

	public static TreeMap<CabBean, Integer>  getCabBean() {
		cabAvailableAtcutOffTime = new TreeMap<CabBean, Integer>();
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB001", 100040, true),
				100040);// true cab available
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB002", 100070, true),
				100070);
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB004", 100060, true),
				100060);
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB005", 100080, true),
				100080);
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB006", 100050, true),
				100050);
		cabAvailableAtcutOffTime.put(new CabBean("DL01HB007", 100035, true),
				100035);
		return cabAvailableAtcutOffTime;
	}
	public static List<BookingRequest> getBookingReq(){
		bookingReq = new ArrayList<BookingRequest>();
		bookingReq.add(new BookingRequest("BR001", 100020, 100040, 1)); // book for 1  am
		bookingReq.add(new BookingRequest("BR002", 100031, 100040, 2));
		bookingReq.add(new BookingRequest("BR003", 100024, 100060, 13)); // book for
																			// 1
																			// pm
		bookingReq.add(new BookingRequest("BR004", 100035, 100070, 15));
		bookingReq.add(new BookingRequest("BR004", 100060, 100070, 16));
		Collections.sort(bookingReq);
		
		return bookingReq;

	}

}
