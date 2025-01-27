// Animal class (Superclass)
class Animal {
    // Attributes of animal
    protected String name;
    protected int age;

    // Constructor for animal
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to make sound
    public void makeSound() {
        System.out.println("Animal make sound");
    }
}

// Dog class (subclass)
class Dog  extends Animal {
    // Constructor for dog
    public Dog(String name, int age) {
        // Call the constructor from the superclass
        super(name, age);
    }

    // Overriding make sound method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof! Woof!");
    }
}

// Cat class (Subclass)
class Cat extends Animal {
    // Constructor for cat
    public Cat(String name, int age) {
        // Call the constructor from the superclass
        super(name,age);
    }

    // Overriding make sound method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow! Meow!");
    }
}

//Bird class (subclass)
class Bird extends Animal {
    // Constructor for bird
    public Bird(String name, int age) {
        // Call the constructor from the superclass
        super(name, age);
    }

    // Overriding make sound method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Chirp! Chirp! Chirp!");
    }
}

// Main Class
class AnimalHierarchy {
    public static void main(String[] args) {
        // Creating name and age for each subclass
        Dog dog = new Dog("Alice", 3);
        Cat cat = new Cat("Bob",2);
        Bird bird = new Bird("Charlie", 1);


        // Using polymorphism to call overridden methods
        Animal[] animals = {dog, cat, bird};
        for (Animal animal : animals) {
            animal.makeSound();
            System.out.println();
        }
    }
}
