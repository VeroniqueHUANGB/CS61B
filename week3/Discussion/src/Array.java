package src;

public class Array {

    public static int[] insert(int[] arr, int item, int position){
        int size = arr.length;
        int[] items = new int[size+1];
        System.arraycopy(arr, 0, items, 0,position);
        items[position] = item;
        System.arraycopy(arr, position, items, position+1, size-position);
        return items;


    }


    public static int[] replicate(int[] arr){
        int cap = 0;
        for (int i = 0; i < arr.length; i++){
            cap += arr[i];
        }
        int[] res = new int[cap];
        int startIdx = 0;
        for (int i =0; i < arr.length; i++){
            int len = arr[i];
            for (int j = 0; j < len; j++){
                res[startIdx] = arr[i];
                startIdx ++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr= {5, 9, 14, 15};
        int[] res = insert(arr, 6, 2);

        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
        int[] arr2 = {3, 2, 1};
        int[] res2 = replicate(arr2);
        for (int i = 0; i < res2.length; i++){
            System.out.println(res2[i]);
        }
    }
}