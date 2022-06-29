package com.wesleyvicen.Serasa.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerActingDTO {
	
	private String nome;
	private LocalDateTime dataInclusao;
	private List<String> estados;

}
