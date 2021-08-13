package com.jda.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jda.relationships.models.LicenseModel;

public interface LicenseRepository extends CrudRepository<LicenseModel, Long> {

	List<LicenseModel> findAll();
	
}
