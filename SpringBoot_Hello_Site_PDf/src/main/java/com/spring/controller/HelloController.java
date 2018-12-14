package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chirag.Goyal
 * 
 */
@RestController
public class HelloController 
{

	/**
	 * this method is used to print hello message
	 */
	@GetMapping
	public String printHello()
	{
		return "Hello this is Site Example";
	}
}
