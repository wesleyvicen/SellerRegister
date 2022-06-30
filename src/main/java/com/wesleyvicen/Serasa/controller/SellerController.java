package com.wesleyvicen.serasa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleyvicen.serasa.dto.SellerActingDTO;
import com.wesleyvicen.serasa.dto.SellerAllDTO;
import com.wesleyvicen.serasa.dto.SellerDTO;
import com.wesleyvicen.serasa.keys.RotasKeys;
import com.wesleyvicen.serasa.service.SellerService;

@RestController
@RequestMapping(value = RotasKeys.SELLER)
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@GetMapping
	public ResponseEntity<List<SellerAllDTO>> findAll() {
		try {
			List<SellerAllDTO> obj = sellerService.findAll();
			return ResponseEntity.ok().body(obj);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@GetMapping(RotasKeys.ID)
	  public ResponseEntity<SellerActingDTO> find(@PathVariable Integer id) {
	    try {
	    	SellerActingDTO obj = sellerService.search(id);
	      return ResponseEntity.ok().body(obj);
	    } catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	  }

	@PostMapping()
	public ResponseEntity<?> addSeller(@RequestBody SellerDTO sellerDto) {
		try {

			return new ResponseEntity<>(sellerService.addSeller(sellerDto), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(("Houve algum erro intento, por favor tente mais tarde."),
					HttpStatus.BAD_REQUEST);
		}
	}
}
