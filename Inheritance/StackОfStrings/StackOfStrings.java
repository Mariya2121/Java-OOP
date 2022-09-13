package Inheritance.StackОfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        data = new ArrayList<>();
    }

    public void push(String element) {
        data.add(element);
    }

    public String pop() {
        return data.remove(data.size() - 1);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }
}
