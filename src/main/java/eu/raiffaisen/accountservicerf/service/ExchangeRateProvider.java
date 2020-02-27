package eu.raiffaisen.accountservicerf.service;

import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;


@Component
public class ExchangeRateProvider {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CacheManager cacheManager;

    private final String url = "https://api.exchangeratesapi.io/latest";

    @CachePut(value = "exchange-rates")
    public ExchangeRatesDTO getExchangerates() throws ParseException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> exchangeRatesDTOResponseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return convertObject(exchangeRatesDTOResponseEntity.getBody());
    }


    private static ExchangeRatesDTO convertObject(String object) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(object);
        ExchangeRatesDTO exchangeRatesDTO = new ExchangeRatesDTO();
        exchangeRatesDTO.setBase((String) jsonObject.get("base"));
        exchangeRatesDTO.setRates((HashMap<String, Double>) jsonObject.get("rates"));
        exchangeRatesDTO.setDate(LocalDate.parse((String) jsonObject.get("date")));
        return exchangeRatesDTO;
    }
}
