package com.nitrocabs;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class BussinessLogic {
	
	static CabBean availCapForRequest(TreeMap<CabBean, Integer> tmap,BookingRequest bookingReq ) {

		int diff = -1;
		double profit = -1;
		String cabId = "";
		int pickUpArea = bookingReq.getPickUpArea();
		int dropArea = bookingReq.getDropArea();
		int diffInReqArea = Math.abs(bookingReq.getPickUpArea()	- bookingReq.getDropArea());
		int costOnReq = diffInReqArea * 10;
		Set<Map.Entry<CabBean, Integer>> entrySet = tmap.entrySet();
		Iterator it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<CabBean, Integer> enty = (Entry<CabBean, Integer>) it.next();
			CabBean cabBean = enty.getKey();			
			Integer currentCabAvailLoc = enty.getValue();
			int basiccostToReachatPickArea = Math.abs(pickUpArea- currentCabAvailLoc) * 5;
			//if profit then check if able to reach before 15 minuts
			if (getProfit(costOnReq, basiccostToReachatPickArea)) {				
				if(capReachBefore15Min(pickUpArea,currentCabAvailLoc, diff))
				{
					return cabBean;
					
				}//reach before 15 minuts
			}//profit
		} 
		return null;
		
	}

	static boolean getProfit(int costOnReq, int basiccostToReachatPickArea) {
		double profit;
		if (costOnReq > basiccostToReachatPickArea) {
			profit = ((costOnReq - basiccostToReachatPickArea) * 100)/ costOnReq;			
			if (profit >= 20)
				return true;
			else
				return false;
		} else
			return false;

	}
	
	static boolean capReachBefore15Min(int pickUpArea,int currentCabAvailLoc, int timeDiff)
	{
		if (timeDiff == -1) {
			timeDiff = Math.abs(pickUpArea - currentCabAvailLoc);
			int timeTaken = timeDiff * 2;// minuts
			if (timeTaken <= 15) {						
				return true;
			}		
		}return false;
		
	}

}
