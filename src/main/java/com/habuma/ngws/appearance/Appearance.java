package com.habuma.ngws.appearance;

import java.util.Date;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.hateoas.Identifiable;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.location.Location;

@RelationshipEntity
public class Appearance implements Identifiable<Long>{

	@GraphId
	private Long nodeId;
	
	@StartNode
	private Citizen citizen;
	
	@EndNode
	private Location location;
	
	private Date timestamp;
	
	private String comment;
	
	private String routine;
	
	private Appearance() {}
	
	public Long getId() {
		return nodeId;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRoutine() {
		return routine;
	}

	public void setRoutine(String routine) {
		this.routine = routine;
	}
	
}
