package mk.ukim.finki.wp.service.taxiCrawler;

import java.io.IOException;

import org.json.JSONException;

import mk.ukim.finki.wp.model.Taxi;

public interface TaxiInfoCrawlerI {

	public Taxi getTaxi (String path) throws IOException, JSONException;
	
}
