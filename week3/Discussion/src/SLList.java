package src;

public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;
    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public void insert(int item, int position){
        if (position <= 0){
            addFirst(item);
            return;
        }

        int cnt = 0;
        IntNode p = first;
        IntNode prev = null;
        while(cnt < position && p != null){
            prev = p;
            p = p.next;
            cnt ++;
        }

        IntNode node = new IntNode(item,p);
        prev.next = node;

    }
    private IntNode removeItemHelper(int x, IntNode current){

        if (current == null){
            return null;
        }
        else if (current.item == x){
            return removeItemHelper(x, current.next);
        }
        else{
            current.next = removeItemHelper(x, current.next);
            /** 把这个结点保留下来*/
            return current;
        }

    }

    /** Recursively removes all nodes that contain a certain item. */
    public void removeItem(int x){
        removeItemHelper(x, first);
    }

    public void reverse(){
        if (first == null) return;
        if (first.next == null) return;
        IntNode cur  = first;
        IntNode prev = null;

        while (cur!= null){
            IntNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        first = prev;
    }

    public void print(){
        IntNode p = first;
        while (p != null) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public static void main(String[] args){
        SLList list = new SLList();
        list.addFirst(0);
        list.insert(3, 2);
        list.insert(1, 1);
        list.insert(2, 2);

        //list.print();
        list.removeItem(2);
        list.print();
        list.reverse();
        list.print();



        //System.out.println(list.size());

    }



}