package com.hexaware.CricketTeamManagementSystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;
import com.hexaware.CricketTeamManagementSystem.entities.Player;
import com.hexaware.CricketTeamManagementSystem.service.IPlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	
	@Autowired
	IPlayerService service;
	
	
	@PostMapping("/add")
	public Player addplayer(@RequestBody PlayerDTO playerDTO)
	{
		return service.addPlayer(playerDTO);
	}
	
	@GetMapping("/getall")
	public List<Player> getall()
	{
		return service.getallPlayers();
	}
	
	@GetMapping("/getbyid/{playerId}")
	public Player getplayer(@PathVariable Integer playerId)
	{
		return service.getPlayer(playerId);
	}
	
	@PutMapping("/update/{playerId}")
	public Player updateplayer(@PathVariable Integer playerId,@RequestBody PlayerDTO playerDTO)
	{
		return service.updatePlayer(playerId,playerDTO);
	}
	
	@DeleteMapping("/delete/{playerId}")
	public String deleteplayer(@PathVariable Integer playerId)
	{
		return service.deletePlayer(playerId);
	}
	
}
