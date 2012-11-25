package com.habuma.ngws.location;

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
@RequestMapping("/locations")
public class LocationController {

	private LocationResourceAssembler resourceAssembler;
	private LocationRepository locationRepository;

	@Inject
	public LocationController(LocationRepository locationRepository) {
		this.resourceAssembler = new LocationResourceAssembler();
		this.locationRepository = locationRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Iterable<LocationResource> allLocations() {
		return resourceAssembler.toResources(locationRepository.findAll());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getLocation(@PathVariable("id") long id) {
		Location location = locationRepository.findOne(id);
		if (location == null) {
			return new ResponseEntity<ApiError>(new ApiError("Location not found (id:" + id +")"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LocationResource>(resourceAssembler.toResource(location), HttpStatus.OK);
	}
	
}
