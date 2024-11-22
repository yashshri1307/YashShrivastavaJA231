package com.hexaware.CricketTeamManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CricketTeamManagementSystem.entities.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player,Integer> {

	public Player findByJerseyNumberAndTeamName(Integer jerseyNumber, String teamName);
}
