package com.habuma.ngws.citizen;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.habuma.ngws.ApiError;

@Controller
@RequestMapping("/citizens")
public class CitizenController {

	private CitizenResourceAssembler resourceAssembler;
	private CitizenRepository citizenRepository;

	@Inject
	public CitizenController(CitizenRepository citizenRepository) {
		this.resourceAssembler = new CitizenResourceAssembler();
		this.citizenRepository = citizenRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Iterable<CitizenResource> allCitizens() {
		System.out.println("GETTING");
		return resourceAssembler.toResources(citizenRepository.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> citizenByKey(@PathVariable("id") Long id) {
		Citizen citizen = citizenRepository.findOne(id);
		if (citizen == null) {
			return new ResponseEntity<ApiError>(new ApiError("Citizen not found (id:" + id +")"), HttpStatus.NOT_FOUND);
		}
		CitizenResource citizenResource = resourceAssembler.toResource(citizen);
		return new ResponseEntity<CitizenResource>(citizenResource, HttpStatus.OK);
	}
	
}
