package com.sg.barsonline.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sg.barsonline.dto.Trade;

public interface BarsOnlineService {
	
	public List<Trade> getTradeList();
	public String getPendingTradeList();

}
