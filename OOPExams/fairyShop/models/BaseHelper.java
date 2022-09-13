package OOPExams.fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class BaseHelper implements Helper {
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        setName(name);
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void work() {
        this.energy -= 10;
        if (energy <= 0) {
            this.energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
    public long getBrokenInstrument() {
        return instruments.stream().filter(Instrument::isBroken).count();
    }

    public String info() {
        return "Name: " + this.name + System.lineSeparator() +
                "Energy: " + this.energy + System.lineSeparator() +
                String.format("Instruments: %d not broken left", instruments.size() - getBrokenInstrument());

    }
}

