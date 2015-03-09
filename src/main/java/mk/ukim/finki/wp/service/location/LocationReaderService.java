package mk.ukim.finki.wp.service.location;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.model.Municipality;

import org.json.JSONException;
import org.json.JSONObject;

public class LocationReaderService {

	private static String baseUrl = "http://maps.google.com/maps/api/geocode/json?"
			+ "sensor=false&address=";

	public static CityMacedonia getCityLocation(String cityName) throws IOException,
			JSONException {
		JSONObject obj = getDestinationLocation(cityName);
		return fillCityObject(cityName,obj);

	}

	public static Municipality getMunicipality(String municipality)
			throws IOException, JSONException {
		JSONObject obj = getDestinationLocation(municipality);
		return fillMunicipality(municipality,obj);
	}

	private static JSONObject getDestinationLocation(String destination)
			throws IOException, JSONException {
		// build a URL
		String urlRequest = baseUrl + URLEncoder.encode(destination, "UTF-8");
		URL url = new URL(urlRequest);

		// read from the URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();
		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();

		// build a JSON object
		JSONObject obj = new JSONObject(str);
		if (!obj.getString("status").equals("OK"))
			return null;

		return obj;
	}

	private static CityMacedonia fillCityObject(String cityName,JSONObject obj) throws JSONException {
		
		CityMacedonia city = new CityMacedonia();
		city.setCityName(cityName);
		
		JSONObject res = obj.getJSONArray("results").getJSONObject(0);
		JSONObject loc = res.getJSONObject("geometry")
				.getJSONObject("location");
		
		city.setLatitude(loc.getDouble("lat"));
		city.setLongitude(loc.getDouble("lng"));
		
		try {
			Thread.sleep(260);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return city;
	}

	private static Municipality fillMunicipality(String municipalityName,JSONObject obj)
			throws JSONException {
		Municipality municipality = new Municipality();
		municipality.setMunicipalityName(municipalityName);
		JSONObject res = obj.getJSONArray("results").getJSONObject(0);
		JSONObject loc = res.getJSONObject("geometry")
				.getJSONObject("location");

		municipality.setLatitude(loc.getDouble("lat"));
		municipality.setLongitude(loc.getDouble("lng"));

		return municipality;

	}

}
