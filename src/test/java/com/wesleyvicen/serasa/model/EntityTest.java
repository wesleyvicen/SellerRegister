package com.wesleyvicen.serasa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EntityTest {
	
	final static String DEFAULT_STRING = "teste";

	@Test
	void SellerTest() {
		Seller seller = Seller.builder()
				.name(DEFAULT_STRING)
				.age(DEFAULT_STRING)
				.city(DEFAULT_STRING)
				.insertionDate(LocalDateTime.now())
				.phone(DEFAULT_STRING)
				.region(DEFAULT_STRING)
				.state(DEFAULT_STRING)
				.build();
		
		assertEquals(DEFAULT_STRING, seller.getName());
	}
	
	@Test
	void ActingTest() {
		Acting acting = Acting.builder()
				.region(DEFAULT_STRING)
				.states(new ArrayList<>())
				.build();
		
		assertEquals(DEFAULT_STRING, acting.getRegion());
	}

}
