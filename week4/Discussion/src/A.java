public class A {
    public int x = 5;
    public void m1(){
        System.out.println("Am1->" + x);
    }
    public void m2(){
        System.out.println("Am1->" + this.x);
    }

    public void update() {
        x = 99;
    }
}
