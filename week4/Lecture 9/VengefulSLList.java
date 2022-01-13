
public class VengefulSLList<Item> extends SLList<Item>{

    SLList<Item> deleteItems;

    public VengefulSLList(){
        /** super(); */
        deleteItems = new SLList<Item>();
    }
    public VengefulSLList(Item x){
        super(x);
        deleteItems = new SLList<Item>();
    }
    @Override
    public Item removeLast() {
        /** Call Superclass's version of removeLast() */
        Item item = super.removeLast();
        deleteItems.addLast(item);
        return item;
    }

    public void printLostItem(){
        deleteItems.print();
    }

}