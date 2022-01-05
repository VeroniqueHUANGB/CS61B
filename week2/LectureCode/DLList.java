/**Improvement 7: Looking back ...
 *
 * Accelerate the removeLast method, add a prev pointer */

/**
 * Generic DLLists:
 *
 *
 *
 * */

public class DLList{
    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(int i, IntNode n, IntNode p){
            item = i;
            next = n;
            prev = p;
        }

        private IntNode head, tail;
        private int size;

        public DLList(){
            head = new IntNode(-1, tail);
            tail = new IntNode()
            size = 0;
        }
        public DLList(int x){
            IntNode node = new IntNode(x, null);
            head = new IntNode(-1, node);
            size = 1;
        }

    }
}