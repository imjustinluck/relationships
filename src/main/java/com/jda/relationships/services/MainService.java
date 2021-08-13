package com.jda.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.relationships.models.LicenseModel;
import com.jda.relationships.models.PersonModel;
import com.jda.relationships.repositories.LicenseRepository;
import com.jda.relationships.repositories.PersonRepository;

@Service
public class MainService {
	
//	@Autowired replaces constructor
	@Autowired
	private PersonRepository pRepository;
	
	@Autowired
	private LicenseRepository lRepository;
	
//	private final PersonRepository pRepository;
//	
//	private final LicenseRepository lRepository;
//	
//	public MainService(PersonRepository pRepository, LicenseRepository lRepository) {
//		this.pRepository = pRepository;
//		this.lRepository = lRepository;
//	}
	
	public PersonModel createPerson(PersonModel person) {
		return pRepository.save(person);
	}
	
	public LicenseModel createLicense(LicenseModel license) {
		return lRepository.save(license);
	}
	
	public List<PersonModel> getPersons() {
		return pRepository.findAll();
	}
	
	public PersonModel findOne(Long id) {
		Optional<PersonModel> optional = pRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
}
