**Method Overloading:**

- Java allows multiple methods with same name, but different parameter

  - ```java
    public static String longest(AList<String> list){...}
    ```

  - ```java
    public static String longest(SSList<String> list){...}
    ```



**Hypernym and Hyponym ---- inferface and class**

![image-20220109144221712](/Users/huangbinbin/Library/Application Support/typora-user-images/image-20220109144221712.png)

- **Step1:** Define a reference type for hypernym(List61B.java)

  - Use `interface` instead of `class` . 

  - <u>what</u> a List is able to do ,<u>not how</u> to do it.

  - ```java
    public interface List61B<Item>{
      	public void addFirst(Item x);
      	public void addFirst(Item x);
        public void addLast(Item x);
        public Item getFirst();
        public Item getLast();
        public Item get(int i);
        public int size();
        public Item removeLast();
    }
    ```

    

- **Step2:** Specift that SLLists and ALists are hyponyms of that type 

  - Use `implements` keyword.

  - Adding the `@Override` Annotation

    - The only effect of this tag is that the code <u>won't compile</u> if it is not actually an overriding method.
    - Optional reminder
    - Main reason: Protects against typos

  - ```java
    public class SLList<Item> implements List61B<Item>{
      	...
         @Override
        public void addLast(Item x){
        	...
      	}
    }
    ```

- Adjust longest method to work on either kind of list

```java
public static String longest(List61B<String> list){
  	int maxIndex = 0;
  	for (int i = 0; i < list.size(); i++){
      	String longest = list.get(maxIndex);
      	String cur = list.get(i);
      	if (longest < cur){
          	maxIndex = i;
        }
    }
  	return list.get(maxIndex);
}
```



**Overriding vs. Overloading**

- **Overriding**

  - Hierarchical relationship. If a subclass has a method with <u>*the exact same signature*</u> as in the superclass.  Then the subclass overrides the method.

  - ```java
    public interface Animal{
      	public void makeNoise();
    }
    ```

  - ```java
    public class Dog implements Animal{
      	@Override
      	public void makeNoise(){
          	System.out.print("oink");
        }
    }
    ```

- **Overloading**

  - No hierarchical relationship. Methods with the *<u>same name but different signatures</u>* are overloaded.

  - ```java
    public class Dog implements Animal{
      /** makeNoise is overloaded */
      	public void makeNoise(Dogx){
        		...
      	}
    }
    ```

  - ```java
    public Math{
      /** abs is overloaded */
      	public int abs(int a){...}
      	public int abs(double a){...}
    }
    ```



**Interface Inheritance** 

- Interface: The list of all <u>*method signatures*</u>.

- Inheritance: The subclass inherits the signatures from a superclass

- Subclass **must** override all of these methods 

  - Will fail to compile otherwise

- Can be multi-generational

- Copying the Bits

  - If X is a superclass of Y, then memory boxes for X may contain Y. 

  - ```java
    public static void main(String[] args){
      	AList<String> a1 = new AList<String>();
      	a1.addLast("horse");
      	WordUtils.longest(a1); 
      //public static String longest(List61B<String> list)
    }
    ```



**Implementation Inheritance**

- Use `default` keyword 

- ```java
  public interface List61B<Item>{
    	default public void print(){
        	for (int i = 0; i < size(); i++){
            	System.out.print(get(i) + " ");
          }
        	System.out.println();
      }
  }
  ```

- Overriding default method

  - ```java
    public class SLList<Item> implements List61B<Item> {
    		@Override
      	public void print(){
          	for (Node p = sentinel.next; p != null; p = p.next){
              	System.out.println(p.item + " ");
            }
          	System.out.println();     
        }
    }
    ```



**Static Type vs. Dynamic Type**

Every variable in Java has 

- Static type (compile-time type) X

  - Specified at **declaration**. Never changes.

- Dynamic type (run-time type) Y

  - Specified at **instatiation.** (e.g. when using `new`)

- If Y **overrides** the method, Y's method is uses instead.

  - ![image-20220109155137649](/Users/huangbinbin/Library/Application Support/typora-user-images/image-20220109155137649.png)

  - ```java
    public interface Animal {
      	default void greet(Animal a){
          	print("hello animal");
        }
      	default void sniff(Animal a){
          	print("sniff animal");
        }
      	default void flatter(Animal a){
          	print("u r cool animal");
        }
    }
    ```

  - ```java
    public class Dog implements Animal {
      	/** Override*/
      	void sniff(Animal a){
          	print("dog sniff animal");
        }
      	/** Overloaded*/
      	void flatter(Dog a){
          	print("u r cool dog");
        }
    }
    ```

  - ```java
    Animal a = new Dog();
    Dog d = new Dog();
    a.greet(d);					// No override, "hello animal"
    a.sniff(d);					// Override, "dog sniff animal"
    d.flatter(d);				// "u r cool dog"
    a.flatter(d);				// Overloaded, not override. 
    /** 
    Compiler askes "Is there a method in Animal that can handle Dog? Yes! flatter(Animal a)". It then records the signature flatter(Animal a). 
    */
    ```

    





