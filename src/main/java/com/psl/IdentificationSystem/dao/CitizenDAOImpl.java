package com.psl.IdentificationSystem.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.psl.IdentificationSystem.entity.Citizen;

@Component(value="citizenDAO")
public class CitizenDAOImpl implements ICitizenDAO {

	@Autowired
	private JdbcTemplate template;	
	
	public JdbcTemplate getTemplate() {
		return template;
	}



	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}



	@Override
	public Citizen getCitizenDetails(String country, String id) {
		// TODO Auto-generated method stub
		
		Citizen citizen=(Citizen)template.queryForObject("select * from "+country+"_person where uin="+id, new RowMapper<Citizen>(){

			@Override
			public Citizen mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Citizen citizen=new Citizen();
				citizen.setUIN(rs.getBigDecimal("UIN"));
				citizen.setF_name(rs.getString("f_name"));
				citizen.setL_name(rs.getString("l_name"));
				citizen.setCountry(rs.getString("country"));
				citizen.setDob(rs.getDate("dob"));
				citizen.setHeight(rs.getInt("height"));
				citizen.setWeight(rs.getInt("weight"));
				citizen.setSkin_color(rs.getString("skin_color"));
				citizen.setEmail(rs.getString("email"));
				citizen.setFingerPrint(rs.getBlob("fingerprint"));
				citizen.setPhoto(rs.getBlob("photo"));
				citizen.setPh(rs.getBytes("photo"));
				
				
//				System.out.println(
//						
//						"UIN :"+citizen.getF_name()+
//						"\nName :"+citizen.getF_name()+" "+citizen.getL_name()+
//						"\nCountry :"+citizen.getCountry()+
//						"\nDOB :"+citizen.getDob()+
//						"\nHeight :"+citizen.getHeight()+
//						"\nWeight :"+citizen.getWeight()+
//						"\nSkin Color :"+citizen.getSkin_color()+
//						"\nEmail :"+citizen.getEmail()
//						);
				
				
				return citizen;
			}});
		
		return citizen;
		
	}
	

}
