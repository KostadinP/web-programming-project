package mk.ukim.finki.wp.service.taxiCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiCrawlerService implements TaxiCrawlerI {

	private String url = "http://zk.mk/search/?what=taksi+kompanii";

	@Autowired
	TaxiInfoCrawlerI taxiInfo;
	@Autowired
	CrudCityMacedoniaService cityService;

	private Elements pageElements(int skip) throws IOException {
		String urlPath = url + "&skip=" + skip;
		Document doc = Jsoup.connect(urlPath).get();
		Elements taxiElements = doc.select("a.companyname");

		return taxiElements;
	}

	private Elements getAllElements() {
		int skip = 0;
		Elements elementList = new Elements();
		Elements pageElements;
		do {
			try {
				pageElements = pageElements(skip);
				elementList.addAll(pageElements);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			skip += 20;
		} while (pageElements.size() > 0);

		return elementList;
	}

	public ArrayList<Taxi> getAll() throws IOException, JSONException {
		Elements elements = getAllElements();
		ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
		HashMap<Integer,CityMacedonia> cityMap = cityService.findAllasHashMap();
		
		for (Element element : elements) {
			try{
				Taxi tempTaxi = taxiInfo.getTaxi(element.attr("href"), cityMap);
				taxiList.add(tempTaxi);
			}
			catch(Exception er){
				er.printStackTrace();
				
			}
		
		}

		return taxiList;
	}

}
