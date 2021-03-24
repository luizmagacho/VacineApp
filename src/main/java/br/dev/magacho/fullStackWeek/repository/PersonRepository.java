package br.dev.magacho.fullStackWeek.repository;

import br.dev.magacho.fullStackWeek.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
