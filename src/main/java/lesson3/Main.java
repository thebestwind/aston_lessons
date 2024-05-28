package lesson3;

class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "234@mailbox.com", "8923234", 310000, 30);
        employees[1] = new Employee("Vasiliev Vasiliy", "QA", "345@mailbox.com", "89231345", 320000, 34);
        employees[2] = new Employee("Maximov Max", "Chief", "456@mailbox.com", "8923456", 330000, 23);
        employees[3] = new Employee("Grgoriev Grigory", "Lead", "567@mailbox.com", "892567", 340000, 32);
        employees[4] = new Employee("Yrev Yrii", "QA", "678@mailbox.com", "89231678", 350000, 34);

        for (Employee employee : employees) {
            employee.printInfo();
        }
    }
}