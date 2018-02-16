package com.sg.barsonline.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.barsonline.dto.Trade;
import com.sg.barsonline.services.BarsOnlineService;

@RestController
public class BarsOnlineResource {
	
	 @Autowired
	 BarsOnlineService barsOnlineService;
	 
	 @GetMapping(value = "/resturl")
	public @ResponseBody List<Trade> getTradeList(){
		
		return barsOnlineService.getTradeList();
	}

}
