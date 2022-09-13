package OOPExams.christmasRaces.repositories.interfaces;

import christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {

    private Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return models.stream().filter(race -> race.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Race race) {
        models.add(race);
    }

    @Override
    public boolean remove(Race race) {
        return models.remove(race);
    }
}
