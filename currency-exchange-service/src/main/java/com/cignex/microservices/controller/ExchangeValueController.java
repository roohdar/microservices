package com.cignex.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.microservices.exception.ExchangeValueNotFoundException;
import com.cignex.microservices.model.ExchangeValue;
import com.cignex.microservices.repository.ExchangeValueRepository;

@RestController
public class ExchangeValueController {

	@Autowired
	private ExchangeValueRepository repository;
	@Autowired
	Environment env;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	private ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if(exchangeValue==null) {
			throw new ExchangeValueNotFoundException("There is no convertor for "+from+" to "+to+ " currency");
		}
		exchangeValue.setPort(Integer.parseInt(env.getProperty("server.port")));
		return exchangeValue;
	}

}
