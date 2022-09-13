package Solid.SingleResponsibilityExample;

import java.util.Scanner;

public class InputReader {

    public String readLine(){
        return new Scanner(System.in).nextLine();
    }

    public void printLine(String str){
        System.out.println(str);
        // Този метод е проблем, защото класът трябва да има една отговпрност - да чете входни данни
        // нарушаване на Single Responsibility principle, защото никой не очаква един InputReader да принтира
    }
}
