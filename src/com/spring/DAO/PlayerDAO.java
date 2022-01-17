package com.spring.DAO;

import java.util.List;

import com.spring.model.Player;

public interface PlayerDAO {

	public List<Player> getPlayers();
	public void addPlayer(Player player);
	public Player getPlayer(int id);
}
