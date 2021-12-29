package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Ideologia;
import br.com.alura.forum.modelo.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Partido> {

	List<Partido> findAllByIdeologia(Ideologia ideologia);

	Partido findById(Long idPartido);

}
