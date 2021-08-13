package com.jda.relationships.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jda.relationships.models.LicenseModel;
import com.jda.relationships.models.PersonModel;
import com.jda.relationships.services.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
//	private final MainService service;
//	
//	public MainController(MainService service) {
//		this.service = service;
//	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") PersonModel person) {
		return "person.jsp";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid
			@ModelAttribute("person") PersonModel person, BindingResult result) {
		if (result.hasErrors()) {
			return "person.jsp";
		}
		else {
			service.createPerson(person);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") LicenseModel license, Model model) {
		List<PersonModel> persons = service.getPersons();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}

	@PostMapping("/licenses/new")
	public String createLicense(@Valid 
			@ModelAttribute("license") LicenseModel license, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<PersonModel> persons = service.getPersons();
			model.addAttribute("persons", persons);
			return "license.jsp";
		}
		else {
			service.createLicense(license);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		PersonModel person = service.findOne(id);
		model.addAttribute("person", person);			
		return "show.jsp";	
	}
}
