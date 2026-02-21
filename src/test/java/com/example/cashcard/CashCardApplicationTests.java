package com.example.cashcard;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// Loads full Spring context and starts a real HTTP server on a random port,
// allowing integration tests to send actual HTTP requests (e.g. via TestRestTemplate)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnACashCardWhenDataIsSaved() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Parse the JSON response body into a DocumentContext object, which allows
		// querying the JSON structure using JsonPath expressions
		DocumentContext documentContext = JsonPath.parse(response.getBody());

		// Read the value of the "id" field from the root of the JSON document ("$" = root).
		// Number is used instead of Integer/Long because JsonPath returns a generic numeric type
		Number id = documentContext.read("$.id");

		assertThat(id).isEqualTo(99);

		Number amount = documentContext.read("$.amount");

		assertThat(amount).isEqualTo(123.45);
	}

	@Test
	void shouldNotReturnACashCardWithAnUnknownId(){
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

		assertThat(response.getBody()).isBlank();

	}
}
