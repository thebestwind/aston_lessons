package lesson4;

abstract class Animal {
    protected String name;
    protected boolean isFull;
    static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        this.isFull = false;
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public abstract void eat(Bowl bowl);
}

class Cat extends Animal {
    static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
    @Override
    public void eat(Bowl bowl) {
        if (bowl.getFood() > 0) {
            bowl.decreaseFood();
            this.isFull = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println("В миске недостаточно еды для " + name + ".");
        }
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood() {
        if (food > 0) {
            food--;
        }
    }

    public void addFood(int food) {
        this.food += food;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int dist){
        if (dist <= 500){
            System.out.println("Собака пробежала " + dist + " метров");
        } else {
            System.out.println("Собака не может пробежать больше 500 метров");
        }}
    @Override
    public void eat(Bowl bowl) {
        if (bowl.getFood() > 0) {
            bowl.decreaseFood();
            this.isFull = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println("В миске недостаточно еды для " + name + ".");
        }
    }

    @Override
    public void swim(int dist){
        if (dist <= 10){
            System.out.println("Собака проплыла " + dist + " метров");
        } else {
            System.out.println("Собака не может проплыть больше 10 метров");
        }
    }
}