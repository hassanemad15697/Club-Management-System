package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Player;
import com.spring.service.PlayerService;

@Controller
public class MainController {
	@Autowired
	private PlayerService playerService;

	@RequestMapping("/")
	public String players() {
		return "home";
	}

	@RequestMapping("/players-list")
	public String players(Model model) {
		List<Player> players = playerService.AllPlayers();
		model.addAttribute("players", players);
		return "players-list";
	}

	@RequestMapping("/add-player")
	public String addPlayer(Model model) {
		Player player = new Player();
		model.addAttribute("playerData", player);
		return "add-player";
	}

	@RequestMapping("/addNewPlayer")
	public String signupNewUser(@Valid @ModelAttribute("playerData") Player player, BindingResult bindingResult,
			Model model) {
		System.out.println(bindingResult);
		player.setPlayerID(5);
		playerService.savePlayer(player);
		// redirect to player list = calling addPlayer method
		return "redirect:players-list";

	}

	@RequestMapping("/updatePlayer")
	public String updatePlayer(Model model, @RequestParam("playerID") int id) {
		Player player = playerService.getPlayer(id);
		model.addAttribute("playerData", player);
		return "add-player";
	}
}
