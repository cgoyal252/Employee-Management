package com.springdata.jpa.restController;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.springdata.jpa.SpringBootEmployeeApplication;
import com.springdata.jpa.config.H2JpaConfig;

/**
 * @author Chirag.Goyal
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootEmployeeApplication.class, H2JpaConfig.class })
public class ProjectDetailsControllerTest 
{

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();	}

	
	//for post request
	
	@Test
	public void verifyCreateProjectDetails() throws Exception {
		String json="{\r\n\"projectOwner\" :\"retail\",\r\n\"startDate\" :"
				+ " \"2018-10-05T12:08:31.185Z\",\r\n\"endDate\" : \"2018-10-05T12:08:31.185Z\"\r\n}";
		
		
		mockMvc.perform(post("/api/projectDetail/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.projectDetailId").exists())
		.andExpect(jsonPath("$.projectOwner").exists())
		.andExpect(jsonPath("$.projectOwner").value("retail"))
		.andDo(print());
	}

/*	
	// for getting list of productDetails
	@Test
	public void verifygetAllProjectDetails() throws Exception {
		
		mockMvc.perform(get("/api/projectDetail/")
        .contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.*",Matchers.hasSize(2)))
		.andDo(print());
	}
	
	@Test
	public void verifygetAllProjectDetails1() 
	{RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl
	  = "http://localhost:8089/api/projectDetail";
	ResponseEntity<String> response
	  = restTemplate.getForEntity(fooResourceUrl,String.class);
	assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	
}*/
}