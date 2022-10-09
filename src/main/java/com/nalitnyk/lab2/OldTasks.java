package com.nalitnyk.lab2;

import java.util.Arrays;
import java.util.Scanner;

public class OldTasks {
    private static final Scanner sc = new Scanner(System.in);

    public static void discriminator() {
        System.out.println("~~~ Calculating the discriminator ~~~\n");
//       a*x^2+b*x+c
        double a, b, c, result;

        System.out.println("Your equation: " + "a*x^2+b*x+c");
        a = enterDouble("a");
        System.out.println("Your equation: " + a + "x^2+b*x+c");
        b = enterDouble("b");
        System.out.println("Your equation: " + a + "x^2" + ((b >= 0) ? "+" + b : b) + "x+c");
        c = enterDouble("c");
        System.out.println("Your equation: " + a + "x^2" + ((b >= 0) ? ("+" + b) : b) + ((b >= 0) ? ("+" + c) : c) + "c");

        result = b * b - 4 * a * c;
        System.out.println("The discriminator: " + result);
    }

    public static void power() {
        System.out.println("~~~ Power the specific number to the specific power ~~~\n");
        double num = enterDouble("number");
        double pow = enterDouble("pow");

        double result = Math.pow(num, pow);
        System.out.println("The result: " + result);
    }

    public static void findMinInArr() {
        System.out.println("~~~ Find minimum in the array~~~\n");
        System.out.println("The minimum: " + Arrays.stream(createArray()).min().getAsInt());
    }

    public static void findMaxInArr() {
        System.out.println("~~~ Find maximum in the array~~~\n");
        System.out.println("The maximum: " + Arrays.stream(createArray()).max().getAsInt());
    }

    private static int[] createArray() {
        int length = enterInt("array's length: ");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = enterInt("a[" + i + "]=");
        }
        return arr;

    }

    private static double enterDouble(String text) {
        System.out.println("Enter " + text + "\n>>> ");
        return sc.nextDouble();
    }

    private static int enterInt(String text) {
        System.out.print("Enter " + text);
        return sc.nextInt();
    }
}
