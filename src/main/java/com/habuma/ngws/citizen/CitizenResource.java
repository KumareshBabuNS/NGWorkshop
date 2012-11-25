package com.habuma.ngws.citizen;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class CitizenResource extends ResourceSupport {

	private Citizen citizen;

	public CitizenResource(Citizen citizen) {
		this.citizen = citizen;
	}
	
	@JsonProperty("id")
	public long getCitizenId() {
		return citizen.getId().longValue();
	}
	
	public String getName() {
		return citizen.getName();
	}
	
	public String getTagLine() {
		return citizen.getTagLine();
	}

}
