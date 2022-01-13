/** Discussion 4: Question 2 */

public class AnimalLauncher {
    public static void main(String[] args){
        Animal a = new Animal("Doh", 3);
        Cat c1 = new Cat("Kitty", 1);
        Cat c2 = new Cat("Kitty_Big", 10);
        c1.greet();
        c2.greet();
    }
}