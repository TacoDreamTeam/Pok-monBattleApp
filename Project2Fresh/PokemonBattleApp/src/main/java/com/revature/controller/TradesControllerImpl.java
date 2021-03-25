package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trades;
import com.revature.service.TradesService;


@Controller("tradesController")
@CrossOrigin(origins = "http://localhost:4200")
public class TradesControllerImpl implements TradesController {

	private static Logger logger = Logger.getLogger(TradesControllerImpl.class);
	
	@Autowired
	private TradesService tradesService;
	
//	public TradesControllerImpl() {
//		logger.trace("Injection session factory bean, TradesControllerImpl");
//	}
	
	@PostMapping("/TradesInsert")
	public @ResponseBody ClientMessage insertTrades(@RequestBody Trades trade) {
		return(tradesService.insertTrades(trade)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/TradesUpdate")
	public void updateTrades(@RequestBody Trades trade) {
		tradesService.updateTrades(trade);

	}

	@GetMapping("/TradesGetAll")
	public List<Trades> selectAllTrades() {
		return tradesService.selectAllTrades();
	}

	@PostMapping("/TradesGetById")
	public Trades FindTradesById(@RequestBody int id) {
		return tradesService.FindTradesById(id);
	}

	@PostMapping("/TradesDelete")
	public void deleteTrades(@RequestBody int id) {
		tradesService.deleteTrades(id);
	}

}
