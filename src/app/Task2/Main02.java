package app.Task2;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main02 {
    static final String CURRENCY = "USD";

    public static void main(String[] args) {
        showData(sortData(getData()));

    }

    static Map<String, Double> getData() {
        Map<String, Double> productList = new HashMap<>();
        productList.put("apple", 1.05);
        productList.put("berry", 1.95);
        productList.put("cherry", 1.99);
        productList.put("banana", 2.00);
        productList.put("milk", 2.99);
        productList.put("chocolate", 3.15);
        return productList;
    }

    static Stream<Map.Entry<String, Double>> sortData(Map<String, Double> productList) {
        return productList.entrySet().stream().filter(unit -> unit.getValue() <= 2.0);

    }

    static void showData(Stream<Map.Entry<String, Double>> productList) {
        AtomicInteger cnt = new AtomicInteger(1);
        productList.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((name, price) -> System.out.println(cnt.getAndIncrement() + ") "
                        + name + " - " + CURRENCY + " " + price));
    }
}
