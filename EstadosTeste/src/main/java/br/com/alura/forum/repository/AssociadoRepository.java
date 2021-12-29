package br.com.alura.forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.forum.modelo.Associado;
import br.com.alura.forum.modelo.CargoPolitico;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	List<Associado> findAllByCargoPolitico(CargoPolitico cargo);

	List<Associado> findAllByPartidoId(Long id);

	Associado findByIdAssociado(Long idAssociado);

}
