package org.launchcode.petstore.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.launchcode.petstore.data.CatData;
import org.launchcode.petstore.data.CatRepository;
import org.launchcode.petstore.data.DogData;
import org.launchcode.petstore.data.DogRepository;
import org.launchcode.petstore.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Controller
public class HomeController {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    CatRepository catRepository;


    @GetMapping()
    public String createHomePage(Model model) {
        model.addAttribute("dogs", dogRepository.findAll());
        model.addAttribute("cats", catRepository.findAll());

        try {
            // Get Information From Open Weather API
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q=Saint%20Louis&appid=618c8f3a0faf85e0c605f114b589bbdd").asString();

            // Convert response into a JSON object
            String body = response.getBody();
            JSONParser parser = new JSONParser(body);

            // Get weather description
            LinkedHashMap<String, Object> weatherData = parser.object(); // parser.object() gets the JSON Object from the parser
            ArrayList<LinkedHashMap<String, Object>> weather = (ArrayList<LinkedHashMap<String, Object>>)weatherData.get("weather");
            if (weather.size() > 0) {
                model.addAttribute("weather", weather.get(0).get("description"));
            }

            // Get Temperature
            LinkedHashMap<String, Object> temp = (LinkedHashMap<String, Object>) weatherData.get("main");
            if (temp.containsKey("temp")) {
                // "BigDecimal" is what is passed back from the API, found out through trial and error
                BigDecimal tempInKelvin = (BigDecimal) temp.get("temp");
                // Convert K to F
                Double tempInFahrenheit = ((tempInKelvin.doubleValue() - 273.15) * 1.8) + 32;
                // Round long decimal value to two decimal places
                tempInFahrenheit = (double) Math.round(tempInFahrenheit * 100) / 100;
                model.addAttribute("temp", tempInFahrenheit.toString());
            }

        } catch(Exception ex) {
            model.addAttribute("weather", " ERROR OCCURRED - DEBUG ME ");
            model.addAttribute("temp", " ERROR OCCURRED - DEBUG ME ");
        }
        return "index";
    }
}
