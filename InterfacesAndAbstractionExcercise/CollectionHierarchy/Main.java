package InterfacesAndAbstractionExcercise.CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner =  new Scanner(System.in);

         AddCollection addCollection = new AddCollection();
         AddRemovable addRemovable = new AddRemoveCollection();
         MyListImpl myList = new MyListImpl();

         String[] input = scanner.nextLine().split(" ");

         int removeCount = Integer.parseInt(scanner.nextLine());

         printAdd(input,addCollection);
         printAdd(input,addRemovable);
         printAdd(input, myList);

         printRemove(removeCount, addRemovable);
         printRemove(removeCount, myList);
    }

    private static void printRemove(int counter, AddRemovable collection) {
        for (int i = 0; i < counter; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void printAdd(String[] input, Addable collection) {
        for (String element : input) {
            System.out.print(collection.add(element) + " ");
        }
        System.out.println();
    }
}
