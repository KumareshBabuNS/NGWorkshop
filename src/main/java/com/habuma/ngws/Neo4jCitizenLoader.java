package com.habuma.ngws;

import org.springframework.transaction.annotation.Transactional;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.citizen.CitizenRepository;
import com.habuma.ngws.location.Location;
import com.habuma.ngws.location.LocationRepository;


public class Neo4jCitizenLoader implements CitizenLoader {

	private CitizenRepository citizenRepository;
	private LocationRepository locationRepository;

	public Neo4jCitizenLoader(CitizenRepository citizenRepository, LocationRepository locationRepository) {
		this.citizenRepository = citizenRepository;
		this.locationRepository = locationRepository;
	}
	
	@Transactional
	public void loadData() {
		loadCitizens();
		loadLocations();
	}

	private void loadCitizens() {
		if (citizenRepository.count() == 0) { // only load if there are no citizens
			citizenRepository.save(new Citizen("Officer Percivel Peabody", "If there's trouble around, he's in it."));
			citizenRepository.save(new Citizen("Mimi Kaboom (Original)", "Dwamatic Actwess"));
			citizenRepository.save(new Citizen("Mimi Kaboom (New)", ""));
			citizenRepository.save(new Citizen("Jack Diamond", "If you've made it in Hollywood yet, it's because you don't know Jack!"));
			citizenRepository.save(new Citizen("Evie Starlight", "She may not be the brightest star in Hollywood, but she sure knows how to sparkle!"));
			citizenRepository.save(new Citizen("Paige Turner", ""));
			citizenRepository.save(new Citizen("Dorma Nesmond", ""));
			citizenRepository.save(new Citizen("Chef Ben Appetite", ""));
			citizenRepository.save(new Citizen("Betty Shambles", ""));
			citizenRepository.save(new Citizen("Daley Reels", ""));
			citizenRepository.save(new Citizen("Holden Hollywood", ""));
			citizenRepository.save(new Citizen("Stone Granite", ""));
			citizenRepository.save(new Citizen("Alberto Dante", "Filmaker Extrodinare. Often imitated but never nominated."));
			citizenRepository.save(new Citizen("Dara Vamp", ""));
			citizenRepository.save(new Citizen("Veronica Vanisht", ""));
			citizenRepository.save(new Citizen("Vladimir Pooey", ""));
			citizenRepository.save(new Citizen("Officer William Club", ""));
			citizenRepository.save(new Citizen("Cloe Canard", ""));
			citizenRepository.save(new Citizen("Ginny Vermouth", ""));
			citizenRepository.save(new Citizen("Shelby Mayer", ""));
			citizenRepository.save(new Citizen("Beau Wrangler", ""));
		}
	}
	
	private void loadLocations() {
		if (locationRepository.count() == 0) { // only load if there are no locations
			locationRepository.save(new Location("Sorcerer's Hat"));
			locationRepository.save(new Location("Sunset Blvd"));
			locationRepository.save(new Location("Hollywood Blvd"));
			locationRepository.save(new Location("Echo Lake"));
		}
	}
}
