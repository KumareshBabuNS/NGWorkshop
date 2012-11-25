package com.habuma.ngws.appearance;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.citizen.CitizenController;
import com.habuma.ngws.citizen.CitizenResource;
import com.habuma.ngws.location.Location;
import com.habuma.ngws.location.LocationController;
import com.habuma.ngws.location.LocationResource;

public class AppearanceResource extends ResourceSupport {

	private Appearance appearance;

	public AppearanceResource(Appearance appearance) {
		this.appearance = appearance;
	}
	
	public String getComment() {
		return appearance.getComment();
	}
	
	public String getRoutine() {
		return appearance.getRoutine();
	}
	
	public Date getTimestamp() {
		return appearance.getTimestamp();
	}
	
	public CitizenResource getCitizen() {
		Citizen citizen = appearance.getCitizen();
		CitizenResource resource = new CitizenResource(citizen);
		resource.add(linkTo(CitizenController.class).slash(citizen).withSelfRel());
		return resource;
	}
	
	public LocationResource getLocation() {
		Location location = appearance.getLocation();
		LocationResource resource = new LocationResource(location);
		resource.add(linkTo(LocationController.class).slash(location).withSelfRel());
		return resource;
	}

}
