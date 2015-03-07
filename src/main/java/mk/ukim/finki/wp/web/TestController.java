package mk.ukim.finki.wp.web;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.wp.model.CityMacedonia;
import mk.ukim.finki.wp.model.Location;
import mk.ukim.finki.wp.model.Municipality;
import mk.ukim.finki.wp.model.Taxi;
import mk.ukim.finki.wp.service.CrudCityMacedoniaService;
import mk.ukim.finki.wp.service.CrudMunicipalityService;
import mk.ukim.finki.wp.service.CrudTaxiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CrudTaxiService taxiService;

	@Autowired
	private CrudCityMacedoniaService cityService;

	@Autowired
	private CrudMunicipalityService municipalityService;

	@RequestMapping(value = "addTaxi", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Taxi create() {
		Taxi taxi = new Taxi();
		taxi.setTaxiAddress("Adresa");
		taxi.setTaxiInfo("Info");
		taxi.setTaxiName("Ime");
		List<String> broevi = new ArrayList<String>();
		broevi.add("broj1");
		broevi.add("broj2");
		taxi.setTaxiPhones(broevi);
		Location loc = cityService.findOne((long) 1);
		taxi.setTaxiLocation(loc);

		return taxiService.saveAndFlush(taxi);
	}

	@RequestMapping(value = "addCity", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Location createLocation() {
		CityMacedonia loc = new CityMacedonia();
		loc.setLatitude(2);
		loc.setLongitude(4);
		loc.setCityName("Gvg");

		return cityService.save(loc);
	}

	@RequestMapping(value = "addMunicipality", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Location createLocation1() {
		Municipality loc = new Municipality();
		loc.setLatitude(2);
		loc.setLongitude(4);
		loc.setMunicipalityName("Karpos");
		CityMacedonia loc1 = cityService.findOne((long) 1);
		loc.setMunicipalityCity(loc1);

		return municipalityService.save(loc);
	}

	@RequestMapping(value = "getCityByLocation", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Location getLocation() {
		CityMacedonia city = cityService.findByLatitudeAndLongitude(1, 4);

		if (city == null) {
			System.out.println("NULL");
		} else {
			System.out.println(city.getCityName());
			return city;
		}
		return null;

	}
}
