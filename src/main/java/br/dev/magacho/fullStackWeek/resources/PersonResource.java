package br.dev.magacho.fullStackWeek.resources;

import br.dev.magacho.fullStackWeek.domain.Person;
import br.dev.magacho.fullStackWeek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> listAll(){
        return personRepository.findAll();
    }

    @PostMapping
    public Person registerPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable("id") Long id, @RequestBody Person person){
        return personRepository.findById(id).map(
                record -> {
                    record.setNumberOfRegistry(person.getNumberOfRegistry());
                    record.setBirthDate(person.getBirthDate());
                    record.setEmail(person.getEmail());
                    record.setAge(person.getAge());
                    record.setName(person.getName());
                    record.setTelephone(person.getTelephone());
                    return personRepository.save(record);
                }).orElse(null);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return personRepository.findById(id).orElse(null);

    }

}
