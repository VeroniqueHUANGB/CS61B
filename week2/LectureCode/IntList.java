public class IntList
{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public static void main(String[] args)
    {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
        System.out.println(L.iterativeGet(1));
    }
    /** Return the size pf the list using ... recursion! */
    public int size()
    {
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize()
    {
        /** Use p to represent that the variable is holding the pointer*/
        IntList p = this;
        int totalSize = 0;
        while (p != null){
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;

    }


    /** Return the size pf the list using ... recursion! */
    public int get(int index)
    {
        if (index == 0){
            return first;
        }
        return rest.get(index-1);
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