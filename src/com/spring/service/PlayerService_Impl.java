package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.PlayerDAO;
import com.spring.model.Player;

@Service
public class PlayerService_Impl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public List<Player> AllPlayers() {
		return playerDAO.getPlayers();
	}

	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDAO.addPlayer(player);
	}

	@Override
	@Transactional
	public Player getPlayer(int id) {
		return playerDAO.getPlayer(id);
	}

}
