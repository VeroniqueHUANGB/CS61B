**Extends** 

One class to be a hyponym of another class, use `extends`.

```java
public class VengefulSLList<Item> extends SLList<Item>{
  	SLList<Item> deleteItems;
  
  	public VengefulSLList(){
      	super();  /** Can eliminate*/
      	deleteItems = new SLList<Item>();
    }
  	public VengefulSLList(Item item){
      	super(item);		/** Must match*/
      	deleteItems = new SLList<Item>()
    }
  
  	@Override
  	public Item removeLast(){
      	Item backItem = super.removeLast();
      	deleteItems.addLast(backItem);
      	return backItem;
    }
  	
  	/** Prints deleted items. */
  	public void printLostItems(){
      	deleteItems.print()  /** Inherit from SLList */
    }
}
```



- All instance and static variables
- All methods
- All nested classes 
- **private** members **cannot** be directly accesses by **subclasses**.
- **Constructors are not inherited**
  - Java requires taht all contructors must start with <u>a call to one of its superclass's contructors</u>.     ----- *is-a* relationship
  - Make an explicit call the the correct constructor by passing in the item as a parameter to spuer.



**Encapsulation**

- Implementation Inheritance Breaks Encapsulationn

  - ```java
    /** 
    vd.barkMany(3) will output As a verbose dog, I say bark bark bark 
    */
    public class Dog{
      	public void bark(){
           System.out.println("bark");
        }
      	public void barkMany(int N){
          	for (int i = 0; i < N; i++){
              	bark();
            }
        }
    }
    
    public class VerboseDog extends Dog{
      	@Override
      	public void barkMany(int N){
          	System.out.println("As a verbose dog, I say: ");
         		public void barkMany(int N){
          		for (int i = 0; i < N; i++){
              		bark();  /** This method inherit from the Dog class */
            }
        	}
        }  
    }
    ```

  - ```java
    public class Dog{
      	public void bark(){
           barkMany(1);
        }
      	public void barkMany(int N){
          	for (int i = 0; i < N; i++){
              	System.out.println("bark");
            }
        }
    }
    
    public class VerboseDog extends Dog{
      	@Override
      	public void barkMany(int N){
          	System.out.println("As a verbose dog, I say: ");
         		public void barkMany(int N){
          		for (int i = 0; i < N; i++){
              		bark();  
                	/** This will cause infinite loop */
                	/** bark() inherit from Dog which call the method  barkMany(but has been overwritten by VerboseDog)*/
            }
        	}
        }  
    }
    ```



**Type Checking and Casting**

- <u>**If overriden**</u>, decide which method to call based on **run-time** type of variable.

- Compile-Time Type Checking

  - Compiler allows method calls based on **compile-time** type of variable.

    - ```java
      public static void main(String[] args){
        	VengefulSLList<String> vsl = new VengefulSLList<String>();
        	SLList<String> sl = vsl;
        	sl.addLast(50);
        	sl.removeLast();
        	sl.printLostItems();		/** Compile Error !!*/
        
      }
      ```

  - An expression using the `new` keyword has a specified compile-time type.



**Casting**

- Treat an expression as having a different compile-time type

- ```java
  public class Bird{
    	public void gulgate(Bird b){
        	System.out.println("BiGulBi");
      }
  }
  
  public class Falcon extends Bird{
    	public void gulgate(Falcon f){
        	System.out.println("FaGulFa");
      }
  }
  
  public void main(String[] args){
    	Bird bird = new Falcon();
    	Falcon falcon = (Falcon) bird;
    	bird.gulgate(falcon);         // BiGulBi
    	falcon.gulgate(falcon);				// FaGulFa
  }
  
  ```

  - Falcon is <u>overloading</u> the gulgate method, <u>not overriding</u>
  - The compiler chooses the most specific matching method signature from the <u>static type</u> of the invoding class.

