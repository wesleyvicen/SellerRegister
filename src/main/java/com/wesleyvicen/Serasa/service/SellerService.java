package com.wesleyvicen.serasa.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyvicen.serasa.dto.SellerActingDTO;
import com.wesleyvicen.serasa.dto.SellerAllDTO;
import com.wesleyvicen.serasa.dto.SellerDTO;
import com.wesleyvicen.serasa.model.Acting;
import com.wesleyvicen.serasa.model.Seller;
import com.wesleyvicen.serasa.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	ActingService actingservice;

	@Transactional
	public List<SellerAllDTO> findAll() {
		var list = sellerRepository.findAll();
		
		List<SellerAllDTO> listAll = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			Acting acting = actingservice.searchRegion(list.get(i).getRegion());
			listAll.add(SellerAllDTO.builder()
					.nome(list.get(i).getName())
					.telefone(list.get(i).getPhone())
					.idade(list.get(i).getAge())
					.cidade(list.get(i).getCity())
					.estado(list.get(i).getState())
					.estados(acting.getStates())
					.build());
		}
		if(listAll.isEmpty()) {
			 throw new NoSuchElementException("Não existe Vendedores");
		}
		return listAll;
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
			Optional<Seller> obj;
			Acting acting;
			try {
				obj = sellerRepository.findById(id);
				acting = actingservice.searchRegion(obj.get().getRegion());
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("Vendedor não existe");
			}
	    
	    return SellerActingDTO.builder()
	    		.nome(obj.get().getName())
	    		.dataInclusao(obj.get().getInsertionDate())
	    		.estados(acting.getStates())
	    		.build();
	  }

}
