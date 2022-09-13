package OOPExams.CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_NAME);
        }

        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_HEALTH);
        }
        this.health = health;
        isAlive = true;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }


    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        isAlive = this.health > 0;
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {

        if (getArmor() > 0) {
            this.armor -= points;
            if (armor < 0) {
                armor = 0;
                return;
            }
        } else {
            health -= points;
            if (health < 0) health = 0;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.username + System.lineSeparator() +
                "--Health: " + this.health + System.lineSeparator() +
                "--Armor: " + this.armor + System.lineSeparator() +
                "--Gun: " + this.gun.getName();
    }
}
