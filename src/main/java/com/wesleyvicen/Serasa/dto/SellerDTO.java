package com.wesleyvicen.Serasa.dto;

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
public class SellerDTO {
	
	private String nome;
	private String telefone;
	private String idade;
	private String cidade;
	private String estado;
	private String regiao;
	
	

}
