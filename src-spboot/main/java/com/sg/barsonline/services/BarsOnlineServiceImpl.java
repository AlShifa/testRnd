package com.sg.barsonline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sg.barsonline.dto.Trade;

@Component
public class BarsOnlineServiceImpl  implements BarsOnlineService{

	 //@Autowired
	 //BookedTradeRepository bookedTradeRepository;
	 
	@Override
	public List<Trade> getTradeList() {
		
		List<Trade> trades = new ArrayList<>();
		Trade t1 = new Trade();
		t1.setTradeId(1001);
		t1.setType("E");
		t1.setAmout(1001);
		t1.setLocation("US");
		trades.add(t1);
		Trade t2 = new Trade();
		t2.setTradeId(1002);
		t2.setType("B");
		t2.setAmout(10011);
		t2.setLocation("HOG");
		trades.add(t2);
		return trades;
		//return bookedTradeRepository.findAll()
	}

	@Override
	public String getPendingTradeList() {
		// TODO Auto-generated method stub
		return null;
	}

}
