package io.github.yanburigo.service;

import java.util.concurrent.atomic.AtomicLong;

import io.github.yanburigo.modal.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {
		if(person.getEmail() == null || person.getEmail().isBlank()) {
			throw new IllegalArgumentException("The Person email is null or empty!");
		}
		
		var id = new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;
	}

}
