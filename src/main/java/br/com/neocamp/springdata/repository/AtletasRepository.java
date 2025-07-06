package br.com.neocamp.springdata.repository;

import br.com.neocamp.springdata.entities.AtletasEntities;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface para fazer a comunicacao com o banco na tabela atletas, pelo ID do tipo Long e pelo nome da classe
public interface AtletasRepository extends JpaRepository<AtletasEntities, Long> {
}
