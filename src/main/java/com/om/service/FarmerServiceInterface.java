package com.om.service;

import java.util.List;

import com.om.model.Farmer;

public interface FarmerServiceInterface {
	
	public void addFarmerinService(Farmer fs);
	 List<Farmer> getFarmer();
	 Farmer getFarmerById(Integer id);
	boolean updateFarmer(Farmer f);
	public void addFarmer(Farmer f1);
}
