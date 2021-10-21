package com.example.citiesapi.cities;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResources {

	@Autowired
	private CityRepository repository;

	@GetMapping
	public List<City> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<City> findById(@PathVariable Long id) {
		Optional<City> optional = repository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok().body(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}


