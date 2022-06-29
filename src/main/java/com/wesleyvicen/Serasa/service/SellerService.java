package com.wesleyvicen.Serasa.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyvicen.Serasa.dto.SellerActingDTO;
import com.wesleyvicen.Serasa.dto.SellerDTO;
import com.wesleyvicen.Serasa.model.Acting;
import com.wesleyvicen.Serasa.model.Seller;
import com.wesleyvicen.Serasa.repository.ActingRepository;
import com.wesleyvicen.Serasa.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	ActingRepository actingRepository;

	@Transactional
	public List<Seller> findAll() {

		return sellerRepository.findAll();
	}
	
	  @Transactional
	  public SellerDTO addSeller(SellerDTO sellerDto){
	    Seller seller = Seller.builder()
	    		.name(sellerDto.getNome())
	    		.phone(sellerDto.getTelefone())
	    		.age(sellerDto.getIdade())
	    		.city(sellerDto.getCidade())
	    		.state(sellerDto.getEstado())
	    		.region(sellerDto.getRegiao())
	    		.insertionDate(LocalDateTime.now())
	    		.build();
	    
	    sellerRepository.save(seller);
	    
	    
	   return sellerDto;
	  }
	  
	  @Transactional
	  public SellerActingDTO search(Integer id) {
	    Optional<Seller> obj = sellerRepository.findById(id);
	    Acting acting = actingRepository.searchRegion(obj.get().getRegion());
	    return SellerActingDTO.builder()
	    		.nome(obj.get().getName())
	    		.dataInclusao(obj.get().getInsertionDate())
	    		.estados(acting.getStates())
	    		.build();
	  }

}
