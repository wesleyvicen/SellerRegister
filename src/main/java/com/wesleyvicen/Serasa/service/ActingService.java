package com.wesleyvicen.serasa.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyvicen.serasa.dto.ActingDTO;
import com.wesleyvicen.serasa.model.Acting;
import com.wesleyvicen.serasa.repository.ActingRepository;

@Service
public class ActingService {

	@Autowired
	ActingRepository actingRepository;

	@Transactional
	public List<Acting> findAll() {
		var list = actingRepository.findAll();
		if (list.isEmpty()) {
			throw new NoSuchElementException("Não existe Atuações cadastradas");
		}
		return list;
	}

	@Transactional
	public ActingDTO addActing(ActingDTO actingDto) {
		Acting acting = Acting.builder()
				.region(actingDto.getRegiao())
				.states(actingDto.getEstados())
				.build();

		actingRepository.save(acting);

		return actingDto;
	}
	
	public Acting searchRegion(String region) {
		return actingRepository.searchRegion(region);
	}

}
