package lesson2;
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

public class lesson2 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "2133454234@mail.ru", "892312312", 30000, 30);
        employees[0] = new Employee("Иванов Иван", "Engineer", "2134234@mail.ru", "776565432", 1200, 67);
        employees[1] = new Employee("Васильев Васильев", "Engineer", "2234134@mail.ru", "756765432", 1300, 45);
        employees[2] = new Employee("Горбачов Иван", "Engineer", "2233454134@mail.ru", "75675432", 1100, 34);
        employees[3] = new Employee("Яшин Яша", "Engineer", "2136784@mail.ru", "766754352", 1100, 56);
        employees[4] = new Employee("Жоров Жора", "Engineer", "2134534@mail.ru", "763455432", 1400, 76);
        for (Employee employee : employees) {
            employee.printInfo();
        }
    }
}

