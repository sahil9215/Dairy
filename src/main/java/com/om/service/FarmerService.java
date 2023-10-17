package com.om.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.Dao.FarmerDaoInterface;
import com.om.model.Farmer;
@Service
@Transactional
public class FarmerService implements FarmerServiceInterface {
	@Autowired
	private FarmerDaoInterface fdoi;

	public void addFarmerinService(Farmer fs) {
		
		fdoi.addFarmerInDao(fs);
	
		
	}

	public List<Farmer> getFarmer() {
		// TODO Auto-generated method stub
		List<Farmer> list=fdoi.getFarmer();
		return list;
	}

	public Farmer getFarmerById(Integer id) {
		// TODO Auto-generated method stub
		return fdoi.getFarmerById(id);
		
	}

	public boolean updateFarmer(Farmer f) {
		// TODO Auto-generated method stub
		return fdoi.updateFarmer(f);
		
	}

	public void addFarmer(Farmer f1) {
		// TODO Auto-generated method stub
		fdoi.addFarmInDao(f1);
		
	}

}
