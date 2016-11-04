package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.RecDaoImpl;
import model.RecModel;

@RestController
public class RecControl {
	
	@Autowired 
	RecDaoImpl recDaoImpl;
	
	@ResponseBody
	@RequestMapping(value = "/getContentId",params="contentId", method = RequestMethod.GET)
	public RecModel csvRead(@RequestParam("contentId")String contentId) {
		System.out.println("Inside controller with contentId = "+contentId);
		RecModel record=recDaoImpl.getEntry(contentId);
		System.out.println();
		return record;
	}
		
}
// /RecTrial/contentTrenddata.csv