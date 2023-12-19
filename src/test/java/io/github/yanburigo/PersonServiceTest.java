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
	IPersonService service;

	@BeforeEach
	void setup() {
		person = new Person("Keith", "Moon", "yan.burigo@outlook.com", "Wembley - UK", "Male");
		service = new PersonService();
	}

	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_whenSuccess_ShouldReturnPersonObject() {

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(actual, () -> "The createPerson() should not have returned null!");
	}

	@DisplayName("When Create a Person with Success Should Contains Valid Fields In Returned Person Object")
	@Test
	void testCreatePerson_whenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(person.getId(), () -> "Person ID is Missing");
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The Person FistName is Incorrect!");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The Person LastName is Incorrect!");
		assertEquals(person.getAddress(), actual.getAddress(), () -> "The Person Address is Incorrect!");
		assertEquals(person.getGender(), actual.getGender(), () -> "The Person Gender is Incorrect!");
		assertEquals(person.getEmail(), actual.getEmail(), () -> "The Person Email is Incorrect!");
	}
	
	@DisplayName("When Create a Person whith Null Email Should Throw Illegal Argument Exception")
	@Test
	void testCreatePerson_whithNullEmail_ShouldThrowIllegalArgumentException() {

		// Given / Arrange
		person.setEmail(null);
		
		var expectedMessage = "The Person email is null or empty!";

		// When / Act & Then / Assert
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.createPerson(person), () -> "Empty Email should have cause an IllegalArgumentException!");
		assertEquals(expectedMessage, exception.getMessage(), () -> "Exception error message is incorrect!");
	}
}
