package br.com.alura.forum.form;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.alura.forum.modelo.Associado;
import br.com.alura.forum.modelo.CargoPolitico;
import br.com.alura.forum.modelo.Partido;
import br.com.alura.forum.modelo.Sexo;
import br.com.alura.forum.repository.AssociadoRepository;

public class AssociadoForm {

	
	private Long idAssociado;
	@NotBlank(message = "Este campo é obrigatório!")
	private String nome;
	@Enumerated(EnumType.STRING)
	private CargoPolitico cargoPolitico;
	@NotNull(message = "Este campo é obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@ManyToOne
	@JoinColumn
	private Partido partido;

	public Long getIdAssociado() {
		return idAssociado;
	}

	public Partido getPartido() {
		return partido;
	}

	public String getNome() {
		return nome;
	}

	public CargoPolitico getCargoPolitico() {
		return cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Associado converter(AssociadoRepository associadoRepository) {
		return new Associado(nome, cargoPolitico, dataNascimento, sexo, partido);
	}

	public Associado atualiza(Long id, AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.getOne(id);

		associado.setNome(this.nome);
		associado.setCargoPolitico(this.cargoPolitico);
		associado.setDataNascimento(this.dataNascimento);
		associado.setSexo(this.sexo);

		return associado;

	}
}
