package com.nalitnyk;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.*;

// Приклад GET-запиту
public class GetRequestExample {

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

    public static void main(String[] args) throws Exception {
        // Повертає курс валют у форматі .xml
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
        String text = getHTML(url);
        System.out.println(text);
        JSONObject obj = (new JSONArray(text)).getJSONObject(0);
        JSONArray array = new JSONArray(text);

        for (int i = 0; i < array.length(); i++) {
            JSONObject elem = array.getJSONObject(i);
            System.out.println(elem.getString("ccy") + "|||" + elem.getString("base_ccy") + "|||" + elem.getString("buy"));
        }
        System.out.println();
    }
}