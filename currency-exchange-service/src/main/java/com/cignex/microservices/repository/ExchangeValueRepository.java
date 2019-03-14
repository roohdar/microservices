package com.cignex.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.microservices.model.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{

	public ExchangeValue findByFromAndTo(String from, String to);


}
