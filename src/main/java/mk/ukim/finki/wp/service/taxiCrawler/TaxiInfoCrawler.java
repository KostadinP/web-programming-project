package mk.ukim.finki.wp.service.taxiCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;
import mk.ukim.finki.wp.service.location.LocationReaderService;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiInfoCrawler implements TaxiInfoCrawlerI {

	private Document doc;
	private String url = "http://zk.mk/";

	@Autowired
	private CrudCityMacedoniaService cityService;

	private void init(String path) {
		try {
			doc = Jsoup.connect(url + path).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Taxi getTaxi(String path, HashMap<Integer,CityMacedonia> hashMap)
			throws IOException, JSONException {

		init(path);
		Taxi taxi = new Taxi();
		taxi.setTaxiName(getTaxiName());
		setTaxiLocation(taxi, hashMap);
		taxi.setTaxiAddress(getTaxiAddress());
		setTaxiPhones(taxi);

		return taxi;
	}

	private void setTaxiLocation(Taxi taxi, HashMap<Integer,CityMacedonia> cityMap) throws IOException, JSONException {
		
		String location = getTaxiLocation();
		CityMacedonia city = LocationReaderService.getCityLocation(location);
		
		if(cityMap.containsKey(city.hashCode())){
			taxi.setTaxiLocation(cityMap.get(city.hashCode()));
		}
		else{
			cityService.save(city);
			city = cityService.findByLatitudeAndLongitude(city.getLatitude(), city.getLongitude());
			cityMap.put(city.hashCode(), city);
			taxi.setTaxiLocation(city);
		}
	}

	private String getTaxiName() {
		Elements taxiElements = doc.select("a.companyname");
		Element elem = taxiElements.get(0);
		return elem.text();
	}

	private String getTaxiAddress() {
		Elements taxiElements = doc.select("li[itemprop=streetAddress]");
		if (taxiElements.size() > 0) {
			Element elem = taxiElements.get(0);
			String[] array = elem.text().split(": ");
			return array[1];
		}
		return "";
	}

	private String getTaxiFirstPhone() {
		Elements taxiElements = doc.select("a[itemprop=telephone]");
		Element elem = taxiElements.get(0);
		return elem.text();
	}

	private String getTaxiLocation() {
		Elements taxiElements = doc.select("li[itemprop=addressLocality]");
		Element elem = taxiElements.get(0);
		String[] array = elem.text().split(": ");
		return array[1];
	}

	private boolean checkForAnotherPhone(Element elem) {
		StringTokenizer tokenizer = new StringTokenizer(elem.text());
		while (tokenizer.hasMoreTokens()) {
			if (tokenizer.nextToken().equals("Телефон"))
				return true;
		}
		return false;
	}

	private void setTaxiPhones(Taxi taxi) {
		Elements taxiElements = doc.select(".details li");
		ArrayList<String> taxiPhones = new ArrayList<String>();
		taxiPhones.add(getTaxiFirstPhone());

		for (Element element : taxiElements) {
			if (checkForAnotherPhone(element)) {
				String[] array = element.text().split(": ");
				taxiPhones.add(array[1]);
			}
		}
		taxi.setTaxiPhones(taxiPhones);
	}



}
