package com.jda.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.relationships.models.PersonModel;

public interface PersonRepository extends CrudRepository<PersonModel, Long> {

	List<PersonModel> findAll();
	
}
