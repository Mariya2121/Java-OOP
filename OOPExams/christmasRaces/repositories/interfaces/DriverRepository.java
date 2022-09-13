package OOPExams.christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> models;

    public DriverRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return models.stream().filter(model -> model.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Driver driver) {
        models.add(driver);
    }

    @Override
    public boolean remove(Driver driver) {
        return models.remove(driver);
    }
}
