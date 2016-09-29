package com.psl.IdentificationSystem.dao;

import java.util.List;

import com.psl.IdentificationSystem.entity.Criminal;

public interface ICriminalDAO {
	public List<Criminal> getCriminalDetails(String country, String id);
}
