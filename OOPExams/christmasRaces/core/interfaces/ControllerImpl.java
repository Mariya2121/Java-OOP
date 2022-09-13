package OOPExams.christmasRaces.core.interfaces;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    //    private DriverRepository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }


    @Override
    public String createDriver(String driverName) {
        if (driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driverName));
        }
        Driver driver = new DriverImpl(driverName);
        driverRepository.add(driver);
        return String.format(OutputMessages.DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;

        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        carRepository.add(car);

        return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        Car car = carRepository.getByName(carModel);

        //carRepository.getAll().stream().filter(c -> c.getModel().equals(carModel)).findFirst().orElse(null);
        if (car == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race raceByName = raceRepository.getByName(raceName);
        Driver driverByName = driverRepository.getByName(driverName);

        if (raceByName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (driverByName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        raceByName.addDriver(driverByName);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);

    }

    @Override
    public String startRace(String raceName) {
        Race raceByName = raceRepository.getByName(raceName);

        if (raceByName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (raceByName.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        int laps = raceByName.getLaps();
        Collection<Driver> drivers = raceByName.getDrivers(); // All drivers in the race

        List<Driver> winners = drivers.stream().sorted(Comparator.comparingDouble(s -> s.getCar().calculateRacePoints(laps))).limit(3)
                .collect(Collectors.toList());


        return String.format(OutputMessages.DRIVER_FIRST_POSITION, winners.get(2).getName(), raceName) + System.lineSeparator() +
                String.format(OutputMessages.DRIVER_SECOND_POSITION, winners.get(1).getName(), raceName) + System.lineSeparator() +
                String.format(OutputMessages.DRIVER_THIRD_POSITION, winners.get(0).getName(), raceName);

    }

    @Override
    public String createRace(String name, int laps) {
        Race raceByName = raceRepository.getByName(name);

        if (raceByName != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        Race race = new RaceImpl(name, laps);

        raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
