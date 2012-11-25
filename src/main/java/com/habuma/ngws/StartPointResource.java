package com.habuma.ngws;

import org.springframework.hateoas.ResourceSupport;

public class StartPointResource extends ResourceSupport {

	public String getInfo() {
		return "This is the startpoint for the CitizenWatch API";
	}

}
