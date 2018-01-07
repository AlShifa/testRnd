package com.coreJ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CapLocation {
	static int cuttOffBookingTime = 30; //30 min before, assume cutOff booking time 30 min, i.e book before half an hour
	static TreeMap<Integer, String> cabAvailableAtcutOffTime;
	

	static {
		cabAvailableAtcutOffTime = new TreeMap<Integer, String>();
		cabAvailableAtcutOffTime.put(100040, "DL01HB001");
		cabAvailableAtcutOffTime.put(100070, "DL01HB002");
		cabAvailableAtcutOffTime.put(100060, "DL01HB004");
		cabAvailableAtcutOffTime.put(100080, "DL01HB005");
		cabAvailableAtcutOffTime.put(100050, "DL01HB006");
		cabAvailableAtcutOffTime.put(100035, "DL01HB007");
	}

	public static void main(String[] args) {
		// get Boooking request from different sector e.g Sec 100020
		// assume booking request must be before half an hours for more profit
		int reqFrmSector = 100041;
		
		String cabId = availCapFrmSec(cabAvailableAtcutOffTime, reqFrmSector, cuttOffBookingTime);
		System.out.println("Nearest Cab " + cabId);

	}

	static String availCapFrmSec(TreeMap<Integer, String> tmap,
			int reqFrmSector, int cuttOffBookingTime) {
		int diff = -1;
		String cabId = "";
		Set<Map.Entry<Integer, String>> entrySet = tmap.entrySet();
		Iterator it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> enty = (Entry<Integer, String>) it
					.next();
			String cabIdLoc = enty.getValue();
			Integer cabAvailLoc = enty.getKey();
			if (diff == -1) {
				diff = Math.abs(reqFrmSector - cabAvailLoc);

			} else if (diff > Math.abs(reqFrmSector - cabAvailLoc)) {
				System.out.println("reqFromSec ]" + reqFrmSector);
				System.out.println("cabAvailLoc ]" + cabAvailLoc);
				diff = Math.abs(reqFrmSector - cabAvailLoc);
				int timeTaken = diff * 2;// minuts
				System.out.println("Minimum diff distance ] " + diff
						+ "[ Time ]" + timeTaken);
				cabId = cabIdLoc;
				// for meet criteria, assume booking cuttoff time every half an
				// hours
				// 15 minutes before , assume calculate every 30 minutes

				int cuttOfTimeToReach = cuttOffBookingTime - 15;// 15minuts or
																// 7km
																// surrounding
																// ,so that it
																// reach in
																// 15min early
																// at pick
																// point.

				if (timeTaken > cuttOfTimeToReach)
					System.out.println("Can't be reach before 15 minuts ");

			}

		}
		return cabId;
	}

}
