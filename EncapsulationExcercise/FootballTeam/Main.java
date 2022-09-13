package EncapsulationExcercise.FootballTeam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Team> teamMap = new HashMap<>();

        while (!command.equals("END")) {
            String[] commandParts = command.split(";");
            String teamName = commandParts[1];
            try {
                switch (commandParts[0]) {
                    case "Team":
                        Team team = new Team(teamName);
                        teamMap.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = commandParts[2];

                        int endurance = Integer.parseInt(commandParts[3]);
                        int sprint = Integer.parseInt(commandParts[4]);
                        int dribble = Integer.parseInt(commandParts[5]);
                        int passing = Integer.parseInt(commandParts[6]);
                        int shooting = Integer.parseInt(commandParts[7]);

                        if (teamMap.containsKey(teamName)) {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teamMap.get(teamName).addPlayer(player);
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;
                    case "Remove":
                        String playerNameToRemove = commandParts[2];

                        if (teamMap.containsKey(teamName)) {
                            teamMap.get(teamName).removePlayer(playerNameToRemove);
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;
                    case "Rating":
                        if (teamMap.containsKey(teamName)) {
                            System.out.printf("%s - %d%n", teamName, Math.round(teamMap.get(teamName).getRating()));
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
    }
}
