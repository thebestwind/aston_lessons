package lesson4;

import lesson4.Animal;
import lesson4.Shape;
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Шарик");

        Bowl bowl = new Bowl(5);

        System.out.println("В миске " + bowl.getFood() + " порций еды.");

        cat.run(150);
        cat.swim(10);
        cat.eat(bowl);

        dog.run(400);
        dog.swim(5);
        dog.eat(bowl);

        System.out.println("Теперь в миске " + bowl.getFood() + " порций еды.");

        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 5, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, 6, "Yellow", "Purple");

        System.out.println("Круг:");
        circle.displayCharacteristics();

        System.out.println("\nПрямоугольник:");
        rectangle.displayCharacteristics();

        System.out.println("\nТреугольник:");
        triangle.displayCharacteristics();
    }
}