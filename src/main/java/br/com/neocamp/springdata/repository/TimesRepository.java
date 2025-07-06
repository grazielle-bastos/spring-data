package br.com.neocamp.springdata.repository;

import br.com.neocamp.springdata.entities.TimesEntities;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface para fazer a comunicação com o banco na tabela times, pelo ID do tipo Long
public interface TimesRepository extends JpaRepository<TimesEntities, Long> {
}
