package DesignPatterns;

public class Database {
    private static Database instance;

    private Database(){
    }

     public static Database getInstance() {
        if (instance == null){ // Singleton pattern; only one instance
            instance = new Database();
        }
        return instance;
    }
}
