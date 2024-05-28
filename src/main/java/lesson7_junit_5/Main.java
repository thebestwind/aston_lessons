package lesson7_junit_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        int result = factorial(num);
        System.out.printf("Факториал числа %d равен %d%n", num, result);
    }

    public static int factorial(int num) {
        int factorial = 1;
        if (num < 0) {
            throw new IllegalArgumentException("Введите неотрицательное число");
        } else {
        for(int i = 1; i <= num; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}}


