package br.edu.utfpr.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exemplo")
public class MainController {
	
	@GetMapping(value = "/{name}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String sayHello(@PathVariable("name")  String name) {
		return "Olá " + name;
	}
}
