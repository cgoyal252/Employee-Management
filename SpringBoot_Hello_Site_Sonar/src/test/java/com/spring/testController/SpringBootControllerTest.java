package com.spring.testController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.spring.SpringBootHelloSiteApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author Chirag.Goyal
 *
 *This class is used to test the HelloController class
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootHelloSiteApplication.class)
@SpringBootConfiguration
public class SpringBootControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	/**
	 * Setting up the default url for testing
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();	}


	/**
	 *  This method is to check Status of printHello method
	 *  and also print the message if status is 200
	 */
	@Test
	public void verifygetPrintHelloMethod() {

		try {

			mockMvc.perform(get("/")
					.contentType(MediaType.APPLICATION_JSON)          
					.accept(MediaType.APPLICATION_JSON))
			.andExpect(content().string("Hello this is Site Example"))
			.andExpect(status().isOk())                   //checking status is Ok or 200 is or not
			.andDo(print());
		} 
		catch (Exception e) {
			System.out.println("Server error");;
		}
	}
}
