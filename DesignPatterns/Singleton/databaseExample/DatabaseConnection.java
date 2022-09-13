package DesignPatterns.Singleton.databaseExample;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void readData() {
        System.out.println("Reading form DB");
    }

    public void writeData() {
        System.out.println("Writing to DB");
    }
}
