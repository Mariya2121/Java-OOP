package OOPExams.restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double allBills;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

        this.healthFoodRepository = new HealthFoodRepositoryImpl();
        this.beverageRepository = new BeverageRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
        this.allBills = 0.0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        //TODO:
        Food currentFood = null;
        if (type.equals("Salad")) {
            currentFood = new Salad(name, price);
        }
        if (type.equals("VeganBiscuits")) {
            currentFood = new VeganBiscuits(name, price);
        }

//        HealthyFood food = healthFoodRepository.getAllEntities().stream()
//                .filter(f -> f.getName().equals(name)).findFirst().orElse(null);

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }
        healthFoodRepository.add(currentFood);
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        //TODO:
        Beverages currentBeverage = null;
        if (type.equals("Fresh")) {
            currentBeverage = new Fresh(name, counter, brand);
        }
        if (type.equals("Smoothie")) {
            currentBeverage = new Smoothie(name, counter, brand);
        }

//        Beverages beverage = beverageRepository.getAllEntities().stream()
//                .filter(f -> f.getName().equals(name)).findFirst().orElse(null);

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }
        beverageRepository.add(currentBeverage);
        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);

    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        //TODO:

        Table currentTable = null;
        if (type.equals("Indoors")) {
            currentTable = new Indoors(tableNumber, capacity);
        }
        if (type.equals("InGarden")) {
            currentTable = new InGarden(tableNumber, capacity);
        }
//
//        Table table = tableRepository.getAllEntities().stream()
//                .filter(f -> f.getTableNumber() == tableNumber).findFirst().orElse(null);

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        tableRepository.add(currentTable);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);

    }

    @Override
    public String reserve(int numberOfPeople) {
        //TODO:
        Table table = tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople).findFirst()
                .orElse(null);


        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        //TODO:
        Table table = tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }
        table.orderHealthy(food);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        //TODO:
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages beverage = beverageRepository.beverageByName(name, brand);

        if (beverage == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        }
        table.orderBeverages(beverage);
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);

    }

    @Override
    public String closedBill(int tableNumber) {
        //TODO:
        Table table = tableRepository.byNumber(tableNumber);

        double bill = table.bill();
        allBills += bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        //TODO:
        return String.format(OutputMessages.TOTAL_MONEY, allBills);
    }
}
