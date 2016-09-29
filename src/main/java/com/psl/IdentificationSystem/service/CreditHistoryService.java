package com.psl.IdentificationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.IdentificationSystem.dao.ICreditHistoryDAO;
import com.psl.IdentificationSystem.entity.CreditHistory;

@Component(value="credit_history_service")
public class CreditHistoryService {
	@Autowired
	ICreditHistoryDAO dao;
	
	public ICreditHistoryDAO getDao() {
		return dao;
	}

	public void setDao(ICreditHistoryDAO dao) {
		this.dao = dao;
	}
	
	public List<CreditHistory> getCreditDetails(String country,String id){
		return dao.getCreditHistoryDetails(country, id);
	}
}
