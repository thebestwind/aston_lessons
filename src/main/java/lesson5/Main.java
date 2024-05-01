package lesson5;

public class Main {

    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int sum = processArray(array);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (array[i].length != ARRAY_SIZE) {
                throw new MyArraySizeException("Неверный размер массива в строке " + (i + 1));
            }
        }

        for (int i = 0; i < ARRAY_SIZE; i++){
            for (int j = 0; j < ARRAY_SIZE; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный символ: " + array[i][j] + " в строке " + (i + 1) + ", столбце " + (j + 1));
                }
            }
        }
        return sum;
    }
}

