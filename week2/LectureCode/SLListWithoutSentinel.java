
public class SLListWithoutSentinel {


    /** Improvement 4: Nested Classes*/
    /**
     * If the nested class has no need to use any of the instance methods or vairbales of
     * SLList, we may declare the nested class static.
     *
     * Declaring a nested class as static means the methods inside the static class
     * can not access any of the members of the enclosing class.
     * In this case, it means that no method in IntNode would be able to access
     * first, addFirst, or getFirst
     * */

    /** Improvement 1: Rebandinng ... */

    public static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /** Improvement 2: Bureaucracy ... */

    /** Improvement 3: Private vs. Public ... */
    /**
     * Avoid
     * public class SLLTroubleMaker {
     *     public static void main(String[] args) {
     *         SLList L = new SLList(15);
     *         L.addFirst(10);
     *         L.first.next.next = L.first.next;
     *     }
     * }
     *
     * In this case, SLLTroubleMaker will fail to compile,
     * since first has private access in SLList error.
     * */

    private  IntNode first;
    private int size;
    /** Improvement 5: Caching .... */
    /**
     *
     * The practice of saving important data to speed up retrival is known as
     * Caching
     * */

    /** Hide the detail that there exists a null link from the user*/
    public SLListWithoutSentinel(){
        first = null;
        size = 0;
    }
    public SLListWithoutSentinel(int x){
        first = new IntNode(x, null);
        size = 1;
    }
    /** first 始终指向链表的头部，为当前对象的first值*/
    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst(){
        return first.item;
    }

    public void addLastWithoutSentinel(int x){
        /** this 的对象是当前的SLList调用者，first 是SLList的第一个*/
        /** Improvement 6: The empty List */

        IntNode p = first;
        if (p == null){
            this.addFirst(x);
            return;
        }
        else{
            while (p.next != null){
                p = p.next;
            }
            p.next = new IntNode(x, null);

        }
        size += 1;
    }

    public void addLast(int x){
        IntNode p = first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }


//    public static int size(IntNode p){
//        if (p == null){
//            return 0;
//        }
//        return 1 + size(p.next);
//    }
//
//    public int size(){
//        return size(first);
//    }


    /** The below is for Intlist, make make no sense in SLList.
     * A SLList has no rest variable */
//    public int size(){
//        if ( rest  == null){
//            return 1;
//        }
//        return 1+ this.rest.size();
//    }

    public int size(){
        return size;
    }

    public static void main(String[] ars){
        SLListWithoutSentinel L = new SLListWithoutSentinel(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        int x = L.getFirst();
        System.out.println(x);
        System.out.println(L.size());
    }
}

