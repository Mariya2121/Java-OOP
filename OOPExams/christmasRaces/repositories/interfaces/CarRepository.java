package OOPExams.christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return models.stream().filter(car -> car.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Car car) {
        models.add(car);
    }

    @Override
    public boolean remove(Car car) {
        return models.remove(car);
    }
}
