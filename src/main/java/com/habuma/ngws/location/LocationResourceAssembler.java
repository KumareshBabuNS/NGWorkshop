package com.habuma.ngws.location;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class LocationResourceAssembler extends ResourceAssemblerSupport<Location, LocationResource> {

	public LocationResourceAssembler() {
		super(LocationController.class, LocationResource.class);
	}
	
	@Override
	public LocationResource toResource(Location location) {
		return createResource(location);
	}
	
	@Override
	protected LocationResource instantiateResource(Location location) {
		return new LocationResource(location);
	}

}
