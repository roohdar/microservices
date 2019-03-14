package com.cignex.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionValue {

	private Long id;
	private String from;
	private String to;
	private int quantity;
	private int convertMultiple;
	private int total;
	private int port;
	
}
