package com.currency.controller;

import com.currency.model.CurrencyEntity;
import com.currency.model.Exchange;
import com.currency.repository.MySQLRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@ConfigurationProperties(prefix = "source.currency")
public class CurrencyController {

    private String url;
    private MySQLRepository repository;

    CurrencyController(MySQLRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/service/v1/currency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<CurrencyEntity>> start(){
        RestTemplate restTemplate = new RestTemplate();

        Exchange exchange = restTemplate.getForObject(url, Exchange.class);

        if (exchange != null){
            repository.saveAll(exchange.getCurrencies());
            return new ResponseEntity<>(exchange.getCurrencies(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
