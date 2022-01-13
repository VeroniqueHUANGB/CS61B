public class TestAnimals {
    public static void main(String[] args){
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        DogD d = new DogD("Fido", 4);
        a.greet();   // Animal Pluto says: Huh？
        c.greet();  // Cat Garfield says: Meow!
        d.greet();  /** Dognullsays: HUH?*/
        a = c;
        ((Cat) a).greet();  /** Cat Garfieldsays : Meow! */
        a.greet();  /** Cat Garfieldsays : Meow! */
        /**
         * a = new Animal("Fluffy", 2);
         * c = a;   Compiler error
         * c = (Cat) a;  Compile is OK, but runtime error
         */
       a = new DogD("Spot", 10);
       /**
        * d = a;  Compiler error. The static type of d is DogD
        * while the static type of a is Animal.
        * Cannot cast Animal to DogD
        * */

    }

}