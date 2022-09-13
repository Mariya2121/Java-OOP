package DesignPatterns.Singleton.databaseExample;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.readData();
        databaseConnection.writeData();
    }
}
