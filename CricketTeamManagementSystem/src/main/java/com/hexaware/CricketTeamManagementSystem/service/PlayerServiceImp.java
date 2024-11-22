package com.hexaware.CricketTeamManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;
import com.hexaware.CricketTeamManagementSystem.entities.Player;
import com.hexaware.CricketTeamManagementSystem.exception.PlayerNotFoundException;
import com.hexaware.CricketTeamManagementSystem.repository.IPlayerRepository;

@Service
public class PlayerServiceImp implements IPlayerService{

	@Autowired
	IPlayerRepository repo;
	
	@Override
	public List<Player> getallPlayers() {
		
		return repo.findAll();
	}

	@Override
	public Player addPlayer(PlayerDTO playerDTO) {
		
		Player player=new Player();
	
		player.setPlayerName(playerDTO.getPlayerName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		player.setRole(playerDTO.getRole());
		player.setTotalMatches(playerDTO.getTotalMatches());
		player.setTeamName(playerDTO.getTeamName());
		player.setDescription(playerDTO.getDescription());
		
		return repo.save(player);
	}

	@Override
	public Player getPlayer(Integer playerId) {
		
	   return repo.findById(playerId).orElseThrow(()->new PlayerNotFoundException("Player with ID " + playerId + " not found"));
	}

	@Override
	public Player updatePlayer(Integer playerId,PlayerDTO playerDTO) {
		
		
		Player player=new Player();
		
		player.setPlayerId(playerDTO.getPlayerId());
		player.setPlayerName(playerDTO.getPlayerName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		player.setRole(playerDTO.getRole());
		player.setTotalMatches(playerDTO.getTotalMatches());
		player.setTeamName(playerDTO.getTeamName());
		player.setDescription(playerDTO.getDescription());
		
		return repo.save(player);
	}

	@Override
	public String deletePlayer(Integer playerId) {
		
		repo.deleteById(playerId);
		
		return "Record Deleted";
	}

}
