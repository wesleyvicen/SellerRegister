package com.wesleyvicen.Serasa.controller;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleyvicen.Serasa.dto.SellerActingDTO;
import com.wesleyvicen.Serasa.dto.SellerDTO;
import com.wesleyvicen.Serasa.keys.RotasKeys;
import com.wesleyvicen.Serasa.model.Seller;
import com.wesleyvicen.Serasa.service.SellerService;

@RestController
@RequestMapping(value = RotasKeys.SELLER)
public class SellerController {

	@Autowired
	private SellerService sellerService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<Seller> obj = sellerService.findAll();
			return ResponseEntity.ok().body(obj);
		} catch (ObjectNotFoundException e) {
			return new ResponseEntity<>("Não temos nenhum vendedor cadastrado :(", HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<>(("Houve algum erro intento, por favor tente mais tarde."),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(RotasKeys.ID)
	  public ResponseEntity<?> find(@PathVariable Integer id) {
	    try {
	    	SellerActingDTO obj = sellerService.search(id);
	      return ResponseEntity.ok().body(obj);
	    } catch (ObjectNotFoundException e) {
	      return new ResponseEntity<>(
	          String.format("Vendedor de ID %s Não encontrado, por favor tente um ID diferente.", id),
	          HttpStatus.NOT_ACCEPTABLE);
	    } catch (Exception e) {
	      return new ResponseEntity<>(("Houve algum erro intento, por favor tente mais tarde."),
	          HttpStatus.BAD_REQUEST);
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
