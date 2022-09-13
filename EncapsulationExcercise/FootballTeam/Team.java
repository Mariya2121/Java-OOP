package EncapsulationExcercise.FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isExist = players.removeIf(n -> n.getName().equals(playerName));
        if (!isExist) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(player -> player.overallSkillLevel()).average().orElse(0);
    }

}
