public class ExtraIntListPractice {
    public static class IntList{
        public int first;
        public IntList rest;

        public IntList(int f, IntList r){
            first = f;
            r = rest;
        }

        public int size(){
            if (rest == null){
                return 1;
            }
            return 1 + rest.size();

        }

        public int iterativeSize(){
            int cnt = 0;
            IntList p = this;
            while (p != null){
                p = p.rest;
                cnt += 1;
            }
            return cnt;
        }

        public int get(int i){
            if(i == 0){
                return first;
            }
            return rest.get(i-1);
        }

        public int iterativeGet(int i)
        {
            IntList p = this;
            for (int index = 0; index < i; index++){
                p = p.rest;
            }
            return p.first;
        }


    }


    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    /**注意是static*/
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList cur = new IntList(L.first + x, null);
        IntList p = L;
        int size = L.size();
        // while (p.rest != null)
        for (int i = 0; i < L.size()-1; i ++ ){
            p = p.rest;
            cur.rest = new IntList(p.first + x, null);
            cur = cur.rest;
        }
        return cur;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        int size = L.size();
        IntList p = L;
        // while (p != null)
        for (int i = 0; i < size; i++){
            p.first += x;
            p = p.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
         System.out.println(L.get(1));
         System.out.println(incrList(L, 3));
         System.out.println(dincrList(L, 3));
    }
}