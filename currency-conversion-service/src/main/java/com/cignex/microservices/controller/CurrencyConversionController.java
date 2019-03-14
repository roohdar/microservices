package com.cignex.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.microservices.model.ConversionValue;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyExchangeServerProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	private ConversionValue retriveCurrencyConverter(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		ConversionValue retriveExchangedValue = proxy.retriveExchangedValue(from, to);
		retriveExchangedValue.setQuantity(quantity);
		retriveExchangedValue.setTotal(quantity*retriveExchangedValue.getConvertMultiple());

		return retriveExchangedValue;

	}

}
