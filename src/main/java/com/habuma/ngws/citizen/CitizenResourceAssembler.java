package com.habuma.ngws.citizen;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class CitizenResourceAssembler extends ResourceAssemblerSupport<Citizen, CitizenResource> {

	public CitizenResourceAssembler() {
		super(CitizenController.class, CitizenResource.class);
	}
	
	@Override
	public CitizenResource toResource(Citizen citizen) {
		return createResource(citizen);
	}

	@Override
	protected CitizenResource instantiateResource(Citizen citizen) {
		return new CitizenResource(citizen);
	}

}
