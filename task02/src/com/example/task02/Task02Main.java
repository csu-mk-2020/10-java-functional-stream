package com.example.task02;

import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if(n>16 || n<1){
            throw new IllegalArgumentException("not number between [1,16]");
        }
        int mod = (int)Math.pow(2,n);
        return IntStream.generate(new IntSupplier() {
            int num = 0;
            @Override
            public int getAsInt() {
                if (num == mod) num = 0;
                return (num ^ (num++>>1)) & mod-1;
            }
        });
    }

}
