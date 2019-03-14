package com.cignex.microservices.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cignex.microservices.model.ConversionValue;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-server")
public interface CurrencyExchangeServerProxy {

	@GetMapping("/currency-exchange-server/currency-exchange/from/{from}/to/{to}")
	public ConversionValue retriveExchangedValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
