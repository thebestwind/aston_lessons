package lesson6;
import java.util.*;
public class PhoneBook {
    private final Map<String, List<String>> directory = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.get(lastName);
    }

    public static void main(String[] args) {
        PhoneBook directory = new PhoneBook();
        directory.add("Ivanov", "123");
        directory.add("Ivanov", "456");
        directory.add("Petrov", "789");

        System.out.println("Ivanov's phones: " + directory.get("Ivanov"));
        System.out.println("Petrov's phones: " + directory.get("Petrov"));
    }
}
