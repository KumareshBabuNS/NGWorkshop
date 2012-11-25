package com.habuma.ngws;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.habuma.ngws.appearance.AppearanceController;
import com.habuma.ngws.citizen.CitizenController;
import com.habuma.ngws.location.LocationController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private CitizenLoader loader;
	
	@Inject
	public HomeController(CitizenLoader loader) {
		this.loader = loader;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody StartPointResource home() {
		StartPointResource resource = new StartPointResource();
		resource.add(linkTo(HomeController.class).withRel("startpoint"));
		resource.add(linkTo(CitizenController.class).withRel("citizens"));
		resource.add(linkTo(AppearanceController.class).withRel("appearances"));
		resource.add(linkTo(LocationController.class).withRel("locations"));
		return resource;
	}
	
	
	@RequestMapping(value="/load", method=RequestMethod.GET)
	public @ResponseBody String load() {
		loader.loadData();
		return "ok";
	}

}
