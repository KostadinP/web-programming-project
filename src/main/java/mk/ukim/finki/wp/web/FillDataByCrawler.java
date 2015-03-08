package mk.ukim.finki.wp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.repository.CityMacedoniaRepository;
import mk.ukim.finki.wp.repository.TaxiRepository;
import mk.ukim.finki.wp.service.CrudTaxiService;
import mk.ukim.finki.wp.service.taxiCrawler.TaxiCrawlerI;
import mk.ukim.finki.wp.service.taxiCrawler.TaxiCrawlerService;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fillData")
public class FillDataByCrawler {
	
	@Autowired
	CrudTaxiService taxiService;
	@Autowired
	TaxiCrawlerI taxiCrawler;
	
	@RequestMapping(value = "taxi", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Taxi> fillTaxiData () throws IOException, JSONException {
		
		ArrayList<Taxi> taxiList = taxiCrawler.getAll();
		ArrayList<Taxi> newTaxies = new ArrayList<Taxi>();
		for (Taxi taxi : taxiList) {
			if(taxiService.findByTaxiName(taxi.getTaxiName())==null){
				taxiService.save(taxi);
				newTaxies.add(taxi);
			}
		}
		return newTaxies;
	}
}
