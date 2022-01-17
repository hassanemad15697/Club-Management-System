package com.spring.service;

import java.util.List;

import com.spring.model.Player;

public interface PlayerService {
	public List<Player> AllPlayers();

	public void savePlayer(Player player);

	public Player getPlayer(int id);

	public void deletePlayer(Player player);
}
