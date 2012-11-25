package com.habuma.ngws.appearance;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class AppearanceForm {
	
	@JsonProperty("citizen_id")
	private Long citizenId;

	@JsonProperty("location_id")
	private Long locationId;
	
	private String routine;
	
	private String comment;
	
	@JsonCreator
	public AppearanceForm() {}
	
	public Long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getRoutine() {
		return routine;
	}

	public void setRoutine(String routine) {
		this.routine = routine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
