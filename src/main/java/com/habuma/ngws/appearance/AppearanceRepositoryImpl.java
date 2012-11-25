package com.habuma.ngws.appearance;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.location.Location;

@Component
public class AppearanceRepositoryImpl implements AppearanceRepository {

	private Neo4jOperations neo4jOps;

	@Inject
	public AppearanceRepositoryImpl(Neo4jOperations neo4jOps) {
		this.neo4jOps = neo4jOps;
	}
	
	public Iterable<Appearance> findAll() {
		return neo4jOps.findAll(Appearance.class);
	}
	
	@Transactional
	public Appearance create(Citizen citizen, Location location, String routine, String comment) {
		Appearance appearance = neo4jOps.createRelationshipBetween(citizen, location, Appearance.class, "APPEARED_AT", true);
		appearance.setTimestamp(new Date());
		appearance.setRoutine(routine);
		appearance.setComment(comment);
		return neo4jOps.save(appearance);
	}
	
}
