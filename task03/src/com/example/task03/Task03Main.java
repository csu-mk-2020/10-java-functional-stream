package com.example.task03;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Objects.requireNonNull(stream);
        Objects.requireNonNull(order);
        Objects.requireNonNull(minMaxConsumer);
        AtomicReference <T> min = new AtomicReference<>();
        AtomicReference <T> max = new AtomicReference<>();
        stream.forEach(num -> {
            try {
                if (order.compare(num, min.get()) < 0) {
                    min.set(num);
                }
                if (order.compare(num, max.get()) > 0) {
                    max.set(num);
                }
            } catch (NullPointerException e){
                min.set(num);
                max.set(num);
            }
        });
        minMaxConsumer.accept(min.get(),max.get());
    }
}
