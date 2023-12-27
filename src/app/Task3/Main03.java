package app.Task3;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

public class Main03 {
    public static void main(String[] args) {
        showData(sortData(getData()));
    }

    static Map<String, Integer> getData() {
        Map<String, Integer> indexes = new HashMap<>();
        indexes.put("Monday", 8);
        indexes.put("Tuesday", 13);
        indexes.put("Wednesday", 10);
        indexes.put("Thursday", 12);
        indexes.put("Friday", 15);
        indexes.put("Saturday", 11);
        indexes.put("Sunday", 9);
        return indexes;

    }

    static Stream<Map.Entry<String, Integer>> sortData(Map<String, Integer> indexes) {
        return indexes.entrySet()
                .stream()
                .filter(value -> value.getValue() >= 10 & value.getValue() <= 13);
    }

    static void showData(Stream<Map.Entry<String, Integer>> indexes) {
        System.out.println("Result of measurements :");
        AtomicInteger cnt = new AtomicInteger(1);
        indexes.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((day, value) -> System.out.println(cnt.getAndIncrement() + ") " + day +
                        " - " + value));

    }
}
