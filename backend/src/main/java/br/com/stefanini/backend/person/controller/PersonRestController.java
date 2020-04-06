/**
 * @solution  : STEFANINI (back-end)
 * @objective : PROCESSO SELETIVO --> VAGA (DEV SR REC)
 */
package br.com.stefanini.backend.person.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.stefanini.backend.person.exception.PersonNotFoundException;
import br.com.stefanini.backend.person.model.Person;
import br.com.stefanini.backend.person.repository.PersonRepository;
import lombok.Setter;

/**
 * @author     : guilherme.athayde.nc@gmail.com
 * @phone      : 81 99687.3959
 * @profession : senior full stack developer analyst
 * @date       : 05/04/2020
 */

@Setter
@RestController
@RequestMapping("/person/")
@CrossOrigin
public class PersonRestController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("person")
    public ResponseEntity<Person> person()
    {
        Person p = new Person();
        return ResponseEntity.ok(p);
    }
	
 // Listar todas as pessoas.
	@GetMapping("/api/persons")
	public List<Person> findAllPersons() {
		return personRepository.findAll();
	}
	
//	Buscar uma pessoa pelo id.
	public Person findPersonById(@PathVariable long id) {
		Optional<Person> person = personRepository.findById(id);

		if (!person.isPresent())
			throw new PersonNotFoundException("person id: " + id + " not found!");

		return person.get();
	}
	
//	Cadastrar uma nova pessoa.
	@PostMapping("/api/persons")
	public ResponseEntity<Object> addPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPerson.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
//  Atualizar uma pessoa pelo id.
	@PutMapping("/api/persons/{id}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable long id, @PathVariable String name, @PathVariable String gender, @PathVariable String email, @PathVariable Date birthday, @PathVariable String naturalness, @PathVariable String nationality, @PathVariable String cpf) {

		Optional<Person> personOptional = personRepository.findById(id);

		if (!personOptional.isPresent())
			return ResponseEntity.notFound().build();

		person.setId(id);
		person.setName(name);
		person.setGender(gender);
		person.setEmail(email);
		person.setBirthday(birthday);
		person.setNaturalness(naturalness);
		person.setNationality(nationality);
		person.setCpf(cpf);
		person.setUpdateDate(new java.sql.Date(System.currentTimeMillis()));

		personRepository.save(person);

		return ResponseEntity.noContent().build();
	}
	
//	Remover uma pessoa pelo id.
	public void removePerson(@PathVariable long id) {
		personRepository.deleteById(id);
	}
}