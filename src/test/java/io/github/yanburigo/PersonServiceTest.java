package io.github.yanburigo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.yanburigo.modal.Person;
import io.github.yanburigo.service.IPersonService;
import io.github.yanburigo.service.PersonService;

public class PersonServiceTest {

	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	void testCreatePerson_whenSuccess_ShouldReturnPersonObject() {
		
		// Given / Arrange
		IPersonService service = new PersonService();
		
		Person person = new Person("Keith", "Moon", "yan.burigo@outlook.com", "Wembley - UK", "Male");
		
		// When / Act
		Person actual = service.createPerson(person);
		
		// Then / Assert
	}
}
