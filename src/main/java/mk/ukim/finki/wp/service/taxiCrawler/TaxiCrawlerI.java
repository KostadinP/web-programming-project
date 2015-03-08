package mk.ukim.finki.wp.service.taxiCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import mk.ukim.finki.wp.model.Taxi;

public interface TaxiCrawlerI {
	
	public ArrayList<Taxi> getAll () throws IOException, JSONException;

}
