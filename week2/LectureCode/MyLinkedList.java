/** This is from the LeetCode 707: Design Linked List
 *
 * */
class MyLinkedList {
    public static class IntNode{
        public int val;
        public IntNode next;
        public IntNode prev;

        public IntNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }
    private IntNode head;
    private IntNode tail;
    private int size;


    public MyLinkedList() {
        head = new IntNode(-1);
        tail = new IntNode(-1);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 所有对node操作都是先操作
     * node.next
     * node.prev = p
     * node.next.prev = node
     * p.next = node */

    int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        IntNode p = head;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        return p.next.val;
    }

    void addAtHead(int val) {
        IntNode node = new IntNode(val);
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
        size += 1;
    }

    void addAtTail(int val) {
        IntNode p = tail.prev;
        IntNode node = new IntNode(val);
        node.next = tail;
        node.prev = p;
        node.next.prev = node;
        p.next = node;
        size ++;
    }

    void addAtIndex(int index, int val) {
        if (index < 0 || index > size){
            return;
        }
        IntNode p = head;
        IntNode node = new IntNode(val);
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        node.next = p.next;
        node.prev = p;
        node.next.prev = node;
        p.next = node;
        size += 1;

    }
    void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }
        IntNode p = head;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        p = p.next; //要删的点
        IntNode tempPrev = p.prev;
        IntNode tempNext = p.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
        size --;
    }
     public static void main(String[] args){
         MyLinkedList myLinkedList = new MyLinkedList();
         myLinkedList.addAtHead(1);
         System.out.println(myLinkedList.get(0));
         myLinkedList.addAtTail(2);
         System.out.println(myLinkedList.get(1));
         myLinkedList.addAtIndex(1, 3);// linked list becomes 1->2->3
         System.out.println(myLinkedList.get(1)); // return 2
         myLinkedList.addAtIndex(1, 4);// linked list becomes 1->2->3
         System.out.println(myLinkedList.get(1)); // return 2
 //        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 //        System.out.println(myLinkedList.get(1));
     }
};



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */