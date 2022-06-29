package com.wesleyvicen.Serasa.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyvicen.Serasa.dto.ActingDTO;
import com.wesleyvicen.Serasa.model.Acting;
import com.wesleyvicen.Serasa.model.Seller;
import com.wesleyvicen.Serasa.repository.ActingRepository;

@Service
public class ActingService {

	@Autowired
	ActingRepository actingRepository;

	@Transactional
	public List<Acting> findAll() {

		return actingRepository.findAll();
	}
	
	  @Transactional
	  public ActingDTO addActing(ActingDTO actingDto){
	    Acting acting = Acting.builder()
	    		.region(actingDto.getRegiao())
	    		.states(actingDto.getEstados())
	    		.build();
	    
	    actingRepository.save(acting);
	    
	    
	   return actingDto;
	  }

}
