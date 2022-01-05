- Generic ALists:

```java
public class AList<Item>{
  	Item[] items;
  	int size;
  	
  	public AList(){
      	items = (Item[]) new Object[100];
      	size = 0;
    }
}
```



- Resize:

  ```java
  public void addLast(Item x){
    	if (size == items.length){
        	resize(size * RFACTOR)；
      }
    	items[size] = x;
    	size ++;
  }
  private void resize(int capacity){
    	Item[] a = (Item[]) new Object[capacity]；
      System.arraycopy(items, 0, a, 0, size);
    	items = a;
  }
  
  ```

- removeLast:
  - Java only destroy unwanted objects when the <u>*last references has been lost*</u>. ------- garbage collection.
  - Keeping references to unneeded objects is sometime called *loitering*. 

```java
public Item getLast(){
  	return items[size-1];
}
public Item removeLast(){
  	Items res = getLast();
  	items[size-1] = null;
  	size --;
  	return res;
}
```

