package com.habuma.ngws.location;

import org.springframework.hateoas.ResourceSupport;

public class LocationResource extends ResourceSupport {

	private Location location;

	public LocationResource(Location location) {
		this.location = location;
	}
	
	public Long getLocationId() {
		return location.getId();
	}
	
	public String getName() {
		return location.getName();
	}
	
}
