package com.junit.spring.junitspring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JunitspringApplicationTests {

	private MockMvc mvc; 
	@InjectMocks
	private HelloResource helloresource;
	public void setHelloresource(HelloResource helloresource) {
		this.helloresource = helloresource;
	}
	@Before
	public void setup() throws Exception{
		mvc=MockMvcBuilders.standaloneSetup(helloresource).build();
	}
	@Test
	public void testHelloWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("hello"));
		
	}
	@Test
	public void testjson() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello/json")
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.id",Matchers.is("12")))
		.andExpect(jsonPath("$.name",Matchers.is("manasa")));
		
		
	}
	
	
	
}
