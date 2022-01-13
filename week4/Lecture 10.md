**Subtype Polymorphism**

- In Java, How objects can have many forms or types
- In OOP, how an object can be regarded as an instance of its own class, an instance of its superclass, an instance of its superclass's superclass, and so on.

**Comparable** 

- **Natural order**:  used to refer to the <u>ordering implied in the Comparable's  `compareTo`</u> method of a particular class. 
- It is imbedded within the object itself.
- Single way to compare
- The class implements the `Comparable<Dog>` interface and override the `int compareTo(T o)` method

- ```java
  /** It takes a generic type */
  public interface Comparable<T>{
    	public int compareTo(T obj)
  }
  ```

  ```java
  public class Dog implements Comparable<Dog>{
    		...
        @Override
        public int compareTo(Dog dogx){
           return this.size - dogx.size;
        }
    	...
  }
  ```

  ```java
  public class Maximizer{
    	public static Comparable max(Comparable[] items){
        	int maxDex = 0;
          for (int i = 0; i < items.length; i += 1) {
              int cmp = items[i].compareTo(items[maxDex]);
  
              if (cmp > 0) {
                  maxDex = i;
              }
          }
          return items[maxDex];
      }
  }
  ```

  ```java
  public class DogLauncher{
    	public static void main(Strinng[] args){
        	Dog d1 = new Dog("Elyse", 3);
          Dog d2 = new Dog("Sture", 9);
          Dog d3 = new Dog("Benjamin", 15);
          Dog[] dogs = new Dog[]{d1, d2, d3};
        
        	Dog d = (Dog) Maximizer.max(dogs);
        	System.out.println(d.name);
        
        	Comparator<Dog> nc = Dog.getNameComparator();
        	if (nc.compare(d1, d3) > 0){
            	d3.bark();
          }else{
            	d1.bark();
          } 
      }
  }
  ```



**Comparator**

- Sort in a different way than natural ordering.

  - Using `Comparator`'s. Since a comparator is an object, we use `Comparator` by writing a nested class inside Dog that implements `Comparator` interface.
  - Third party machine compares 2 objects to each other.
  - Multiple ways to compare 

- ```java
  public interface Comparator<T> {
    	int compare(T o1, T o2);
  }
  ```

- ```java
  public class Dog implements Comparable<Dog>{
    		...
        @Override
        public int compareTo(Dog dogx){
           return this.size - dogx.size;
        }
    		private static class NameComparator implements Comparator<Dog>{
          	@Override
          	public int compare(Dog a, Dog b){
              	return a.name.compareTo(b.name);
            }
        }
    
    	public static Comparator<Dog> getNameComparator(){
        	return new NameComparator();
      }
  }
  ```

  