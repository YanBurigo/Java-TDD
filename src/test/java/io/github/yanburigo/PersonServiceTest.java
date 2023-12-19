package io.github.yanburigo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.yanburigo.modal.Person;
import io.github.yanburigo.service.IPersonService;
import io.github.yanburigo.service.PersonService;

public class PersonServiceTest {

	Person person;

	@BeforeEach
	void setup() {
		person = new Person("Keith", "Moon", "yan.burigo@outlook.com", "Wembley - UK", "Male");
	}

	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_whenSuccess_ShouldReturnPersonObject() {

		// Given / Arrange
		IPersonService service = new PersonService();

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(actual, () -> "The createPerson() should not have returned null!");
	}

	@DisplayName("When Create a Person with Success Should Contains FirstName In Returned Person Object")
	@Test
	void testCreatePerson_whenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

		// Given / Arrange
		IPersonService service = new PersonService();

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The Person FistName is Incorrect!");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The Person LastName is Incorrect!");
		assertEquals(person.getAddress(), actual.getAddress(), () -> "The Person Address is Incorrect!");
		assertEquals(person.getGender(), actual.getGender(), () -> "The Person Gender is Incorrect!");
		assertEquals(person.getEmail(), actual.getEmail(), () -> "The Person Email is Incorrect!");
	}
}
