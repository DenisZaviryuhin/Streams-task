package app.Task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;


public class Main01 {
    public static void main(String[] args) {
        showData(sortData(getData()));

    }

    static List<String> getData() {
        return Arrays.asList("Denis", "Joshua", "Jack", "Bob", "Amanda", "Arnold");
    }

    static Stream<String> sortData(List<String> names) {
        return names
                .stream()
                .filter(nm -> nm.startsWith("A"));


    }

    static void showData(Stream<String> names) {
        AtomicInteger cnt = new AtomicInteger(1);
        names.forEach(nm -> System.out.println(cnt.getAndIncrement() + ") " + nm));


    }
}
