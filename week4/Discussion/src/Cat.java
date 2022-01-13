/** Discussion 4: Question 2 */

public class Cat extends Animal{
    protected String name, noise;
    protected int age;

    public Cat(String name, int age){
        super(name, age);
        this.age = age;
        this.name = name;
        this.noise = "Meow!";
    }

    @Override
    public String makeNoise(){
        if(age < 5){
            return noise.toUpperCase();
        }else{
            return noise;
        }
    }
    @Override
    public void greet(){
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
}
