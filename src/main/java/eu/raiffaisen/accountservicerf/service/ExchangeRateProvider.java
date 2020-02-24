package eu.raiffaisen.accountservicerf.service;

import eu.raiffaisen.accountservicerf.dto.ExchangeRatesDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@Component
@CacheConfig(cacheNames = "exchange-rates")
public class ExchangeRateProvider {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "https://api.exchangeratesapi.io/latest";

    @Cacheable
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
        exchangeRatesDTO.setRates((Map) jsonObject.get("rates"));
        exchangeRatesDTO.setDate(LocalDate.parse((String) jsonObject.get("date")));
        return exchangeRatesDTO;
    }
}
