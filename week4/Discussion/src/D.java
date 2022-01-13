public class D {
    public static void main(String[] args){
       /**
        * B a0 = new A();
        * a0.m1();
        * a0.m2(16);
        * */
       A b0 = new B();
       b0.m1();  // Am1 -> 5
       b0.m2();  // Bm2-> 5
       /**
        * b0.m2(16);    The static type pf b0 is A. No method in A is
        * of form void m2(int )
        * The method in B is overloading, not overriding
        * */
        B b1 = new B();
        b1.m2(61);  // Bm2y->61
        b1.m3();    // Bm3->called
        A c0 = new C();
        c0.m2();    // Cm2->5
        /**C c1 = (A) new C();*/
        A a1 = (A) c0;
        C c2  = (C) a1;
        c2.m3(); // Bm3->called
        // c2.m4(); cascading error
        c2.m5(); // Cm5->6
        ((C) c0).m3();  // Bm3->called
        ((C) c0).m2();  // Cm2->5
        b0.update();
        b0.m1();    // Am1->99
    }
}
