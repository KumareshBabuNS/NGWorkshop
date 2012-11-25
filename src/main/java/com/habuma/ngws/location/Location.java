package com.habuma.ngws.location;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.hateoas.Identifiable;

@NodeEntity
public class Location implements Identifiable<Long> {

	@GraphId
	private Long nodeId;

	private String name;
	
	private Location() {}
	
	public Location(String name) {
		this.name = name;	
	}
	
	public Long getId() {
		return nodeId;
	}
	
	public String getName() {
		return name;
	}
	
}
