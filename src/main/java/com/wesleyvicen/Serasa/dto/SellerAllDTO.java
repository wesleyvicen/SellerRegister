package com.wesleyvicen.serasa.dto;

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
public class SellerAllDTO {
	
	private String nome;
	private String telefone;
	private String idade;
	private String cidade;
	private String estado;
	private List<String> estados;

}
