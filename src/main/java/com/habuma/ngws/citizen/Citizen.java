package com.habuma.ngws.citizen;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.hateoas.Identifiable;

@NodeEntity
public class Citizen implements Identifiable<Long> {

	@GraphId
	private Long nodeId;
	
	private String name;
	
	@JsonProperty("tag_line")
	private String tagLine;
	
	private Citizen() {}
	
	public Citizen(String name, String tagLine) {
		this.name = name;
		this.tagLine = tagLine;
	}
	
	public Long getId() {
		return nodeId;
	}
	
	public String getName() {
		return name;
	}

	public String getTagLine() {
		return tagLine;
	}

}
