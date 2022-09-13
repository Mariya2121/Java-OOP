package InterfacesAndAbstractionExcercise.Telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {

        return urls.stream().map(url -> url.matches(".*\\d+.*") ? "Invalid URL!" : "Browsing: " + url + "!")
                .collect(Collectors.joining(System.lineSeparator()));


//        StringBuilder sb = new StringBuilder();
//        for (String url : urls) {
//            if (url.matches("[0-9]")) {
//                sb.append("Invalid URL!").append(System.lineSeparator());
//            } else {
//                sb.append("Browsing: ").append(url).append(System.lineSeparator());
//            }
//        }
//        return sb.toString().trim();
    }

    @Override
    public String call() {

        return numbers.stream().
                map(number -> number.matches(".*\\D+.*") ? "Invalid number!" : "Calling... " + number).
                collect(Collectors.joining(System.lineSeparator()));


//        StringBuilder sb = new StringBuilder();
//        for (String number : numbers) {
//            if (number.matches("[A-Za-z]+")) {
//                sb.append("Invalid number!").append(System.lineSeparator());
//            } else {
//                sb.append("Calling... " + number).append(System.lineSeparator());
//            }
//        }
//        return sb.toString().trim();
    }
}
