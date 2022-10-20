package com.nalitnyk.controller;

import com.nalitnyk.model.ExchangeRate;
import com.nalitnyk.repository.ExchangeRateRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/exchange")
@Component("ExchangeRateController")
public class ExchangeRateController {

    private final ExchangeRateRepository exchangeRateRepository;

//    @Autowired
    @Autowired
    public ExchangeRateController(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @GetMapping
    public ResponseEntity getAllRates() {

        updateDB();

        return ResponseEntity.ok(exchangeRateRepository.findAll());
    }

    private void updateDB() {
        long minutes;
        List<ExchangeRate> rates = exchangeRateRepository.findAll();
        if (rates.isEmpty()) {
            minutes = 99;
        } else {
            Instant hehe = (rates.get(0).getUpdatedAt() == null) ? Instant.ofEpochSecond(0) : rates.get(0).getUpdatedAt();
            minutes = ChronoUnit.MINUTES.between(hehe, Instant.now());

        }


        if (minutes >= 5) {
            System.out.print("\n---Minutes > 5--\n");
            try {
                String pribatbankAPI = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
                String json = getHTML(pribatbankAPI);
                updateTables(json/*, rates*/);


            } catch (Exception e) {
                System.out.println("Не вдалося зробити Get запит");
                throw new RuntimeException(e);
            }
        }
    }

    private void updateTables(String rawJson/*, List<ExchangeRate> rates*/) {
//        rates.clear();
        exchangeRateRepository.deleteAll();
        System.out.println("rawJson: " + rawJson);
        JSONArray array = new JSONArray(rawJson);
        for (int i = 0; i < array.length(); i++) {
            JSONObject elem = array.getJSONObject(i);
//            System.out.println(elem.getString("ccy") + "|||" + elem.getString("base_ccy") + "|||" + elem.getDouble("buy"));
            if (elem.getString("base_ccy").equals("UAH")) {
                ExchangeRate rate = new ExchangeRate();
                rate.setRateToUah(elem.getDouble("buy"));
                rate.setId(elem.getString("ccy"));
                rate.setUpdatedAt(Instant.now());
//                rates.add(rate);
                exchangeRateRepository.save(rate);
                System.out.println("Added!\n");
            }
        }

    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Установлюємо тип запиту
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            // порядково зчитуємо
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
