package com.om.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.om.model.Farmer;

@Repository
@Component
public class FarmerDao implements FarmerDaoInterface {
	   @Autowired
       SessionFactory sessionFactory;
	   
	public void addFarmerInDao(Farmer obj) {

		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 session.save(obj);
		   trans.commit();
		
	
		
	}

	public List<Farmer> getFarmer() {
		// TODO Auto-generated method stub
		
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		List<Farmer> list=(List<Farmer>)session.createQuery("From Farmer").list();
		 trans.commit();
		return list;
	}
	public Farmer getFarmerById(Integer id)
	{
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 Farmer obj=(Farmer)session.get(Farmer.class, id);
	
		 trans.commit();
			return obj;
		
	}

	public boolean updateFarmer(Farmer f) {
		// TODO Auto-generated method stub
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		session.saveOrUpdate(f);
		 trans.commit();
		return true;
	}

	public void addFarmInDao(Farmer f1) {
		Session session=(Session)sessionFactory.getCurrentSession();
		 Transaction trans=session.beginTransaction();
		 session.save(f1);
		   trans.commit();
		
		
	}

}
