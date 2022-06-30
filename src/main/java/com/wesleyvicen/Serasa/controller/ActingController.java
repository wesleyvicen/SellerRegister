package com.wesleyvicen.serasa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleyvicen.serasa.dto.ActingDTO;
import com.wesleyvicen.serasa.keys.RotasKeys;
import com.wesleyvicen.serasa.model.Acting;
import com.wesleyvicen.serasa.service.ActingService;

@RestController
@RequestMapping(value = RotasKeys.ACTING)
public class ActingController {

	@Autowired
	private ActingService actingService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			List<Acting> obj = actingService.findAll();
			return ResponseEntity.ok().body(obj);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Não temos nenhuma atuação cadastrada :(", HttpStatus.NOT_ACCEPTABLE);
		} 

	}

	@PostMapping()
	public ResponseEntity<?> addSeller(@RequestBody ActingDTO sellerDto) {
		try {

			return new ResponseEntity<>(actingService.addActing(sellerDto), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(("Houve algum erro intento, por favor tente mais tarde."),
					HttpStatus.BAD_REQUEST);
		}
	}
}
