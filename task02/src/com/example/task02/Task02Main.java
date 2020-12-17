package com.example.task02;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16)
            throw new IllegalArgumentException("n должно быть < 1 и > 16");


        return IntStream.generate(new IntSupplier() {
            int seed = 0;
            final int period = (int) Math.pow(2, n);
            final int mod = period - 1;

            @Override
            public int getAsInt() {
                if (seed == period) seed = 0;
                int num = (seed ^ (seed >> 1)) & mod;
                ++seed;
                return num;
            }
        });

    }

}
