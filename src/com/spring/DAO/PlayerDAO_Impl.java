package com.spring.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Player;

@Repository
public class PlayerDAO_Impl implements PlayerDAO{
	@Autowired
	private SessionFactory factory ;
	
	@Override
	public List<Player> getPlayers() {
		Session session = factory.getCurrentSession();
		Query<Player> query= session.createQuery("from Player",Player.class);
		return query.getResultList();
	}

	@Override
	public void addPlayer(Player player) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(player);
		
	}

}
