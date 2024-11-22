package com.hexaware.CricketTeamManagementSystem.service;

import java.util.List;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;
import com.hexaware.CricketTeamManagementSystem.entities.Player;

public interface IPlayerService {
	
	public List<Player> getallPlayers();
	
	public Player addPlayer(PlayerDTO playerDTO);
	
	public Player getPlayer(Integer playerId);
	
	public Player updatePlayer(Integer playerId,PlayerDTO playerDTO);
	
	public String deletePlayer(Integer playerId);
	
	public Player findplayerbyJerseyNumberandTeamName(PlayerDTO playerDTO);

}
