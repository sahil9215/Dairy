package com.om.Dao;

import java.util.List;

import com.om.model.Farmer;

public interface FarmerDaoInterface {
	void addFarmerInDao(Farmer obj);
	List<Farmer> getFarmer();
	Farmer getFarmerById(Integer id);
	boolean updateFarmer(Farmer f);
	void addFarmInDao(Farmer f1);

}
