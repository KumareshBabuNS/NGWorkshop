package com.habuma.ngws;

import org.springframework.transaction.annotation.Transactional;

public interface CitizenLoader {

	@Transactional
	void loadData();

}