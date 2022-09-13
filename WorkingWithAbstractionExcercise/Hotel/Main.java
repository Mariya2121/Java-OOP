package WorkingWithAbstractionExcercise.Hotel;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Summer, Winter, Spring, Autumn
        //month,
        // name,
        // averageTemp

        Seasons autumn = Seasons.AUTUMN;
        Seasons.AUTUMN.getAverageTemp();

        System.out.println(Seasons.SUMMER.ordinal()); // index of summer
        System.out.println(Seasons.SPRING.ordinal());

    }

    private static void doSomething(List<Season> seasons) {
    }
}
