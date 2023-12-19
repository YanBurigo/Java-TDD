package io.github.yanburigo.service;

import io.github.yanburigo.modal.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {
		return person;
	}

}
