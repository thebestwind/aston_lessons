import java.util.Arrays;
class lesson1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        sumCheck(5, 4);
        numCheck(2);
        numCheckBool(0);
        multiSrting("ay", 3);
        leapYear(2008);
        mass();
        massAdd();
        arrMultipl();
        arrSq();
        sqMtrx(5, 5);
    }

    static void printThreeWords() {
        System.out.println("Упражнение 1");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        System.out.println("Упражнение 2");
        int a = 5;
        int b = 6;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void printColor() {
        System.out.println("Упражнение 3");
        int value = 60;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        System.out.println("Упражнение 4");
        int a = 3;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static boolean sumCheck(int a, int b) {
        System.out.println("Упражнение 5");
        int sum = a + b;
        boolean sumCheck = (sum > 10 && sum < 20);
        System.out.println(sumCheck);
        return sumCheck;
    }

    static void numCheck(int a) {
        System.out.println("Упражнение 6");
        if (a >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }

    static boolean numCheckBool(int a) {
        System.out.println("Упражнение 7");
        boolean numCheckBool = (a >= 0);
        System.out.println(numCheckBool);
        return numCheckBool;
    }

    static void multiSrting(String b, int a) {
        System.out.println("Упражнение 8");
        System.out.println(b.repeat(a));
    }

    static boolean leapYear(int year) {
        System.out.println("Упражнение 9");
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeapYear);
        return isLeapYear;

    }

    static void mass() {
        System.out.println("Упражнение 10");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++)
            array[i] = 1 - array[i];
        System.out.println(Arrays.toString(array));
    }

    static void massAdd() {
        System.out.println("Упражнение 11");
        int[] myArray = new int[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }

    static void arrMultipl() {
        System.out.println("Упражнение 12");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) {
                array[i] *= 2;
            }
        System.out.println(Arrays.toString(array));
    }

    static void arrSq() {
        System.out.println("Упражнение 13");
        int n = 5;
        int[][] my_array = new int[n][n];
        for (int i = 0; i < n; i++) {
            my_array[i][i] += 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(my_array[i][j] + "");
            }
            System.out.println();
        }
    }

    static void sqMtrx(int len, int initialValue) {
        System.out.println("Упражнение 14");
        int[][] my_array = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                my_array[i][j] += initialValue;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(my_array[i][j] + "");
            }
            System.out.println();
        }
    }
}
