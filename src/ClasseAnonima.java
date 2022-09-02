class Animal {
    public void walk() {
        System.out.println("Animal Walking");
    }
}

public class ClasseAnonima {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void walk() {
                System.out.println("Anonymous Walk");
            }
        };
        animal.walk();
    }
}