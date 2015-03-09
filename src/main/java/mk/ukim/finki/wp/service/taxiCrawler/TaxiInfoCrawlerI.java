package mk.ukim.finki.wp.service.taxiCrawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.model.Taxi;

import org.json.JSONException;

public interface TaxiInfoCrawlerI {

	public Taxi getTaxi(String path, HashMap<Integer,CityMacedonia> citySet)
			throws IOException, JSONException;

}
