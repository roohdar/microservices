package com.cignex.microservices.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionModel {

	private Date timeStamp;
	private String message;
	private String details;
	
}
