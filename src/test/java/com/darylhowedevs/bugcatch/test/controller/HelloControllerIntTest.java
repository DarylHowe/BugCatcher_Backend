package com.darylhowedevs.bugcatch.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.darylhowedevs.bugcatch.controllers.HelloController;

/*
 * This is an integration test for the hello controller class. 
 * 
 */

// Needed with JUnit 5
@ExtendWith(SpringExtension.class)


@WebMvcTest(HelloController.class)
class HelloControllerIntTest {

	// This allows the mvc to be mocked.
	// Allows requests to be mocked.
	@Autowired
	private MockMvc mvc;

	@Test
	void hello() throws Exception {
		RequestBuilder request = get("/hello");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Hello, World", result.getResponse().getContentAsString());
	}

	@Test
	public void testHelloWithName() throws Exception {
		mvc.perform(get("/hello?name=Dan")).andExpect(content().string("Hello, Dan"));
	}
}