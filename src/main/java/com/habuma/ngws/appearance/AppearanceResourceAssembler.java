package com.habuma.ngws.appearance;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.habuma.ngws.citizen.CitizenController;
import com.habuma.ngws.location.LocationController;

public class AppearanceResourceAssembler extends ResourceAssemblerSupport<Appearance, AppearanceResource>{

	public AppearanceResourceAssembler() {
		super(AppearanceController.class, AppearanceResource.class);
	}
	
	@Override
	public AppearanceResource toResource(Appearance appearance) {
		AppearanceResource resource = new AppearanceResource(appearance);
		resource.add(linkTo(CitizenController.class).slash(appearance.getCitizen()).withRel("citizen"));
		resource.add(linkTo(LocationController.class).slash(appearance.getLocation()).withRel("location"));		
		return resource;
	}

}
