**Primitive Type** - byte, short, int, long, float, double, boolean, char

1. Byte - 8 bits 
2. int - 32 bits 
3. The Java language provides no way for you to know the location of the box ---- The exact memory address is below the level of abstraction accessible to us in Java.
4. GRoE: The golden rule of equals
   - When you write  y = x, you are telling the Java interpreter to copy the bits from x into y.



**Reference Type**

1. When *<u>instantiate</u>* an Object using `new` 

   - Java first allocates a box of bits for each instance variable of the class and fills them with a default value(e.g. 0, null)
   - The contructor then usually fills every such box with some other value.

2. Can think of `new`cas returning the *<u>address</u>* of the newly created object. 

   - Addresses in Java are 64 bits

3. Reference Type Variable *<u>Declarations</u>* 

   - Java allocates exactly a box of size 64 bits, no matter what type of object

   - These bits can be either set to:

     - Null(all zeros )  

       ```java
       Walrus someWalrus;
       someWalrus = null;
       ```

     - The 64 bit "address" of a specific instance of that class (returned by `new`)  --> as arrows 

       ```java
       Walrus someWalrus;
       someWalrus = new Walrus(1000, 8.3);
       ```

     

     