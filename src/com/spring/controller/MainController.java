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
	public String addplayer(Model model) {

		Player player = new Player();
		model.addAttribute("playerData", player);
		return "add-player";
	}
	
	@RequestMapping("/addNewPlayer")
	public String signupNewUser(@Valid @ModelAttribute("playerData") Player player, BindingResult bindingResult,Model model) {
		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {

			return "add-player";
		} else {
			playerService.savePlayer(player);
			return "players-list";
		}
	}
}
