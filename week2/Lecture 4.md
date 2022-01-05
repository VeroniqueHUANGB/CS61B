- Improvement 1: Rebaranding 

- Improvement 2: Bureaucracy

```java
public class SLList{
  	public IntNode sentinel;
  	public size;
  	
  	public SLList(){
      	sentinel = new IntNode(-1, null);
        size = 0;
    }
  	public SLList(int x){
      	sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
      	size = 1;
    }
  
  	/** addFirst*/
  
  	public void addFirst(int x){
      	IntNode node = new IntNode(x, null);
      	node.next = sentinel.next;
      	sentinel.next = node;
     		size ++;
    }
  /** getFirst*/
  	public int getFirst(){
      	return sentinel.next.val;
    }
  
}

IntList L1 = new IntList(5, null);
SLList L2 = new SLList(5);

SLList hides the detail that there exists a null link from the user.
  
```



- Improvement 3: ***<u>Access Control</u>***

  Public vs. Private  -- Nested Classes

  In the above code, users of other class might be tempted to try to manipulate our secret IntNode directly in uncouth way

```java
SLList L = new SLList(15);
L.addFirst(10);
L.sentinel.next.next = L.sentinel.next;

```

​	Use `private` keyword to prevent code in *<u>other classes</u>* from using members 	(or constructors) of a class.

```JAVA
private IntNode sentinel;
```

- Improvement 4: Nested class

  Combine 2 classes into one file.

  - **Private or Public**: 

    Make the nested class `private`if <u>***other classes should never use***</u> the nested class.

    We can make `IntNode` class `private`.

  - **Static or non-Static:**

    If a nested class <u>neve</u>r uses any <u>instance variables or methods</u> of the **<u>outer class</u>**, declare it static.

    - Static class cannot access outer class's instance variables or methods.
    - Minor saving for memory.

  ```java
  public class SLList{
    	/** Declare static, since it never uses any of SLList's instance 					variables or methods*/
    	private static class IntNode{
        	public int val;
        	public IntNode next;
       		
        	public IntNode(int val, IntNode next){
            	this.val = val;
            	this.next = next;
          }
      }
    	/** Instance variables, constructors, and methods of SLList 						typically go below nested class definition.
    	*/
    	private IntNode sentinel;
    	private size;
    	
    	public SLList(){
        ...
      }
   	 ... 
  }
  ```

- Improvement 5: Fast size

- Improvement 6: Representing the empty list.

- Improvement 7: Sentinel node

  - delete the corner cases, make all the cases the same. 

​		







