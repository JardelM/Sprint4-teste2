package br.com.alura.forum.form;

import java.time.LocalDate;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.alura.forum.modelo.Ideologia;
import br.com.alura.forum.modelo.Partido;
import br.com.alura.forum.repository.PartidoRepository;

public class PartidoForm {

	private Partido idPartido;
	@NotBlank (message = "Este campo é obrigatório!")
	private String nomeDoPartido;
	@NotBlank (message = "Este campo é obrigatório!")
	private String sigla;
	@NotNull (message = "Este campo é obrigatório!")
	private Ideologia ideologia;
	@NotNull (message = "Este campo é obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy" , shape = JsonFormat.Shape.STRING)
	private LocalDate dataFundacao;
	
	
	public PartidoForm () {
		
	}

	public Partido getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Partido idPartido) {
		this.idPartido = idPartido;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
	public Partido converter(PartidoRepository partidoRepository) {
		return new Partido(nomeDoPartido, sigla, ideologia, dataFundacao);
	}
	
	public Partido atualiza(Partido id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);
		
		partido.setNomeDoPartido(this.nomeDoPartido);
		partido.setSigla(this.sigla);
		partido.setIdeologia(this.ideologia);
		partido.setDataFundacao(this.dataFundacao);
		
		return partido;
	}

}
