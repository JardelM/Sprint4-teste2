package br.com.alura.forum.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Ideologia {
	
	//@JsonProperty("DIREITA")
	DIREITA,
	//@JsonProperty("Centro")
	CENTRO,
	//@JsonProperty("ESQUERDA")
	ESQUERDA

}
