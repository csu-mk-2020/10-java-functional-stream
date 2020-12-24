package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        // your implementation here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("[^a-zа-яё0-9]");
        Stream<String> stream = reader.lines().flatMap(line -> p.splitAsStream(line.toLowerCase()));
        Map<String, Long> words = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        words.entrySet().stream().filter(s -> !s.getKey().equals(""))
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Function.identity(), Map.Entry.comparingByKey()))
                .limit(10).forEachOrdered(entry -> System.out.print(entry.getKey() + "\n"));

    }

}
