package com.psl.IdentificationSystem.dao;

import com.psl.IdentificationSystem.entity.Citizen;

public interface ICitizenDAO {
	public Citizen getCitizenDetails(String country, String id);
}
