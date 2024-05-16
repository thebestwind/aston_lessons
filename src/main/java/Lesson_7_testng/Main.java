package Lesson_7_testng;


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
        for(int i = 1; i <= num; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}



