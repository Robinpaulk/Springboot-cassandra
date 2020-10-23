package com.robin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robin.model.SimpleTable;
import com.robin.repository.CassandraRepository;

@RestController
@RequestMapping("/cassandra")
public class CassandraController {
	
	@Autowired
	private CassandraRepository cassandraRepo; 
	
	@PostMapping
	public ResponseEntity<SimpleTable> saveIntoTable(@RequestBody SimpleTable simpleTable) {
		SimpleTable saveData = cassandraRepo.save(simpleTable);
		return new ResponseEntity<>(saveData, HttpStatus.OK);
	}
	
	@GetMapping(path ="{id}/{name}")
	public ResponseEntity<SimpleTable> fetchRecordsFromTable(@PathVariable("id") int id, @PathVariable("name") String name) {
	Optional<SimpleTable> fetchData =cassandraRepo.findByIdAndName(id,name);
	if(!fetchData.isPresent()) {
		 throw new ArithmeticException("No User");
	}
	return new ResponseEntity<>(fetchData.get(),HttpStatus.OK);
	
	
	}
}
