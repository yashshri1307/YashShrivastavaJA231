package com.hexaware.CricketTeamManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;
import com.hexaware.CricketTeamManagementSystem.entities.Player;
import com.hexaware.CricketTeamManagementSystem.entities.Player.Role;
import com.hexaware.CricketTeamManagementSystem.exception.InvalidRoleException;
import com.hexaware.CricketTeamManagementSystem.exception.PlayerAlreadyExistsException;
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
		
		Player check = repo.findByJerseyNumberAndTeamName(playerDTO.getJerseyNumber(), playerDTO.getTeamName());

		if (check != null) {
			
		    throw new PlayerAlreadyExistsException("Player with the same jersey number already exists in the team");
		}
		Player player=new Player();
	
		player.setPlayerName(playerDTO.getPlayerName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		try {
	        player.setRole(Role.valueOf(playerDTO.getRole())); 
	     } catch (IllegalArgumentException e) {
	    	
	        throw new InvalidRoleException("Invalid role: " + playerDTO.getRole());
	    }
		player.setTotalMatches(playerDTO.getTotalMatches());
		player.setTeamName(playerDTO.getTeamName());
		player.setDescription(playerDTO.getDescription());
		player.setCountryName(playerDTO.getCountryName());
		
		return repo.save(player);
	}

	@Override
	public Player getPlayer(Integer playerId) {
		
		if(!(repo.findById(playerId)).isPresent())
		{
			throw new PlayerNotFoundException("Player with ID " + playerId + " Not Found");
		}
		
	   return repo.findById(playerId).orElseThrow(()->new PlayerNotFoundException("Player with ID " + playerId + " not found"));
	}

	@Override
	public Player updatePlayer(Integer playerId,PlayerDTO playerDTO) {
		
		if(!(repo.findById(playerDTO.getPlayerId())).isPresent())
		{
			throw new PlayerNotFoundException("Player with ID " + playerDTO.getPlayerId() + " Not Found");
		}
		
		Player player=new Player();
		
		player.setPlayerId(playerDTO.getPlayerId());
		player.setPlayerName(playerDTO.getPlayerName());
		player.setJerseyNumber(playerDTO.getJerseyNumber());
		try {
	        player.setRole(Role.valueOf(playerDTO.getRole())); 
	     } catch (IllegalArgumentException e) {
	        throw new InvalidRoleException("Invalid role: " + playerDTO.getRole());
	    }
		player.setTotalMatches(playerDTO.getTotalMatches());
		player.setTeamName(playerDTO.getTeamName());
		player.setDescription(playerDTO.getDescription());
		player.setCountryName(playerDTO.getCountryName());
		
		return repo.save(player);
	}

	@Override
	public String deletePlayer(Integer playerId) {
		
		if(!(repo.findById(playerId)).isPresent())
		{
			throw new PlayerNotFoundException("Player with ID " + playerId + " Not Found");
		}
		
		repo.deleteById(playerId);
		
		return "Record Deleted";
	}

	@Override
	public Player findplayerbyJerseyNumberandTeamName(PlayerDTO playerDTO) {
		
		 return repo.findByJerseyNumberAndTeamName(playerDTO.getJerseyNumber(), playerDTO.getTeamName());
	}

}
