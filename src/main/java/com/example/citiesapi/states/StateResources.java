package com.example.citiesapi.states;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResources {

	@Autowired
	private StateRepository repository;

	@GetMapping
	public List<State> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<State> findById(@PathVariable Long id) {
		Optional<State> optional = repository.findById(id);
		return ResponseEntity.ok().body(optional.get());
	}
}
