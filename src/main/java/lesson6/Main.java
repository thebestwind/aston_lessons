package lesson6;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Создаем массив слов
        String[] words = {"яблоко", "банан", "апельсин", "груша", "яблоко", "банан", "киви", "манго", "яблоко", "киви", "манго", "банан"};

        // Создаем список для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        // Создаем карту для подсчета количества каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим количество каждого слова
        System.out.println("Количество каждого слова: " + wordCount);
    }
}
