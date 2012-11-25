package com.habuma.ngws.appearance;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.citizen.CitizenRepository;
import com.habuma.ngws.location.Location;
import com.habuma.ngws.location.LocationRepository;

@Controller
@RequestMapping("/appearances")
public class AppearanceController {

	private AppearanceRepository appearanceRepository;
	private CitizenRepository citizenRepository;
	private LocationRepository locationRepository;
	private AppearanceResourceAssembler resourceAssembler;

	@Inject
	public AppearanceController(AppearanceRepository appearanceRepository, CitizenRepository citizenRepository, LocationRepository locationRepository) {
		this.resourceAssembler = new AppearanceResourceAssembler();
		this.appearanceRepository = appearanceRepository;
		this.citizenRepository = citizenRepository;
		this.locationRepository = locationRepository;
	}	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Iterable<AppearanceResource> recentAppearances() {
		return resourceAssembler.toResources(appearanceRepository.findAll());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<AppearanceResource> create(@RequestBody AppearanceForm form) {
		Citizen citizen = citizenRepository.findOne(form.getCitizenId());
		Location location = locationRepository.findOne(form.getLocationId());
		Appearance appearance = appearanceRepository.create(citizen, location, form.getRoutine(), form.getComment());
		return new ResponseEntity<AppearanceResource>(resourceAssembler.toResource(appearance), HttpStatus.CREATED);
	}
}
