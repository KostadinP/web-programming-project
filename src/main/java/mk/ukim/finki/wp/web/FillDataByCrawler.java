package mk.ukim.finki.wp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;
import mk.ukim.finki.wp.service.CrudTaxiService;
import mk.ukim.finki.wp.service.taxiCrawler.TaxiCrawlerI;

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
	@Autowired
	CrudCityMacedoniaService cityService;
	
	@RequestMapping(value = "taxi", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Taxi> fillTaxiData () throws IOException, JSONException {
		
		ArrayList<Taxi> taxiList = taxiCrawler.getAll();
		ArrayList<Taxi> newTaxies = new ArrayList<Taxi>();
		HashSet<Integer> taxiSet = taxiService.findAllasHashSet();
	
		for (Taxi taxi : taxiList) {
			
			if(!taxiSet.contains(taxi.hashCode())){
				taxiService.save(taxi);
				taxiSet.add(taxi.hashCode());
				newTaxies.add(taxi);
			}
		}

		return newTaxies;
	}
}
