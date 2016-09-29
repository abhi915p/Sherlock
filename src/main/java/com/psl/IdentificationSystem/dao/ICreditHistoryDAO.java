package com.psl.IdentificationSystem.dao;

import java.util.List;

import com.psl.IdentificationSystem.entity.CreditHistory;

public interface ICreditHistoryDAO {
	public List<CreditHistory> getCreditHistoryDetails(String country, String id);
}
