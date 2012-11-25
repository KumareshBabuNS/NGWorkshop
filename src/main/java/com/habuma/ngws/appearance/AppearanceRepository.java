package com.habuma.ngws.appearance;

import com.habuma.ngws.citizen.Citizen;
import com.habuma.ngws.location.Location;



public interface AppearanceRepository {

	Iterable<Appearance> findAll();

	Appearance create(Citizen citizen, Location location, String routine, String comment);

}
