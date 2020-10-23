package com.robin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robin.model.SimpleTable;
@Repository
public interface CassandraRepository extends CrudRepository<SimpleTable, Integer>{
	Optional<SimpleTable> findByIdAndName(int id, String name);
}
