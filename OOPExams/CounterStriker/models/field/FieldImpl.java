package OOPExams.CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {

        List<Player> terrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist")).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist")).collect(Collectors.toList());

        while (true) {
            for (Player terrorist : terrorists) {
                if (terrorist.isAlive()){
                    for (Player counterTerrorist : counterTerrorists) {
                        if (counterTerrorist.isAlive()){
                            int damagePoints = terrorist.getGun().fire();
                            counterTerrorist.takeDamage(damagePoints);
                        }
                    }
                }
            }

            for (Player counterTerrorist : counterTerrorists) {
                if (counterTerrorist.isAlive()){
                    for (Player terrorist : terrorists) {
                        if (terrorist.isAlive()){
                            int damagePoints = counterTerrorist.getGun().fire();
                            terrorist.takeDamage(damagePoints);
                        }
                    }
                }
            }

            boolean deadTerrorists = terrorists.stream().noneMatch(Player::isAlive);
            boolean deadCounterTerrorists = counterTerrorists.stream().noneMatch(Player::isAlive);

            if (deadTerrorists) {
                return OutputMessages.COUNTER_TERRORIST_WINS;
            }
            if (deadCounterTerrorists) {
                return OutputMessages.TERRORIST_WINS;
            }
        }
    }
}

