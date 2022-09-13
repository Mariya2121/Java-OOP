package OOPExams.restaurant.entities.tables.interfaces;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;



    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setAllPeople() {
        this.allPeople = allPeople();
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        setAllPeople();
        isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double bill = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum()
                + beverages.stream().mapToDouble(s -> s.getPrice() * s.getCounter()).sum();
//        totalMoney += bill;
        return bill;
    }

    @Override
    public void clear() {
        isReservedTable = false;
        this.beverages = new ArrayList<>();
        this.healthyFood = new ArrayList<>();
        this.numberOfPeople = 0;
        this.allPeople = 0;

    }

    @Override
    public String tableInformation() {
        return String.format("Table - " + this.number + System.lineSeparator() +
                "Size - " + this.size + System.lineSeparator() +
                "Type - " + this.getClass().getSimpleName() + System.lineSeparator() +
                "All price - " + this.pricePerPerson);
    }
}
