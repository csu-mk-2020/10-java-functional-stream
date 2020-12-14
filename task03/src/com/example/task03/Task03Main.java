package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;




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
        AtomicReference<T> min = new AtomicReference<>();
        AtomicReference<T> max = new AtomicReference<>();
        stream.forEach(value -> {

            // your implementation here


            try {
                if (order.compare(value, min.get()) < 0) {
                    min.set(value);
                }
                if (order.compare(value, max.get()) > 0) {
                    max.set(value);
                }
            } catch (NullPointerException nullPointerException) {
                min.set(value);
                max.set(value);
            }

        });
        minMaxConsumer.accept(min.get(), max.get());
    }
}
