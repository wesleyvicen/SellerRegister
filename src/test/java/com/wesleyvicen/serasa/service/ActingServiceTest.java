package com.wesleyvicen.serasa.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.wesleyvicen.serasa.repository.ActingRepository;

class ActingServiceTest {

	@InjectMocks
	ActingRepository actingRepository;
	
	@InjectMocks
	ActingService actingService;

	@Test
	void findAllTest() {
		
//		List<Acting> listActings = new ArrayList<Acting>();
//		when(actingRepository.findAll()).thenReturn(listActings);
//		
//		assertNotNull(actingService.findAll());
	}

}
