package com.hexaware.CricketTeamManagementSystem.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class PlayerDTO {
		
		private int playerId;
		
		@Pattern(regexp="[A-Za-z ]+")
		@NotNull
		private String playerName;
		
		@NotNull
		@Positive(message = "Jersey number must be a positive")
		private int jerseyNumber;
		
		@NotNull
		@Enumerated
		private String role;
		
		@NotNull
		@Positive(message = "Total matches must be a positive")
		private int totalMatches;
		
		@Pattern(regexp="[A-Za-z ]+")
		@NotNull
		private String teamName;
		
		@Pattern(regexp="[A-Za-z ]+")
		@NotNull(message = "Country name cannot be null")
		private String countryName;
		
		@NotNull(message = "Description cannot be null")
		private String description;

		public enum Role{
			Batsman,Bowler,Wicket_Keeper,All_rounder
		}
		
		public PlayerDTO() {
			super();
		}

		public PlayerDTO(int playerId, @Pattern(regexp = "[A-Za-z ]+") @NotNull String playerName,
				@NotNull @Positive(message = "Jersey number must be a positive") int jerseyNumber, @NotNull String role,
				@NotNull @Positive(message = "Total matches must be a positive") int totalMatches,
				@Pattern(regexp = "[A-Za-z ]+") @NotNull String teamName,
				@Pattern(regexp = "[A-Za-z ]+") @NotNull(message = "Country name cannot be null") String countryName,
				@NotNull(message = "Description cannot be null") String description) {
			super();
			this.playerId = playerId;
			this.playerName = playerName;
			this.jerseyNumber = jerseyNumber;
			this.role = role;
			this.totalMatches = totalMatches;
			this.teamName = teamName;
			this.countryName = countryName;
			this.description = description;
		}

		public int getPlayerId() {
			return playerId;
		}

		public void setPlayerId(int playerId) {
			this.playerId = playerId;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public int getJerseyNumber() {
			return jerseyNumber;
		}

		public void setJerseyNumber(int jerseyNumber) {
			this.jerseyNumber = jerseyNumber;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getTotalMatches() {
			return totalMatches;
		}

		public void setTotalMatches(int totalMatches) {
			this.totalMatches = totalMatches;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "PlayerDTO [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
					+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", countryName="
					+ countryName + ", description=" + description + "]";
		}

		

	}
