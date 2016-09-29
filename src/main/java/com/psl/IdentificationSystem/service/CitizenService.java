package com.psl.IdentificationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.IdentificationSystem.dao.ICitizenDAO;
import com.psl.IdentificationSystem.entity.Citizen;

@Component(value="citizen_service")
public class CitizenService {
	
	@Autowired
	ICitizenDAO dao;
	
	public ICitizenDAO getDao() {
		return dao;
	}

	public void setDao(ICitizenDAO dao) {
		this.dao = dao;
	}

	public Citizen getCitizenDetails(String country, String id){
		System.out.println(country+" "+id);
		Citizen citizen=dao.getCitizenDetails(country, id);
		return citizen;
	}
}
