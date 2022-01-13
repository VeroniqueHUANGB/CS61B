//public class WordUtils {
//    public static String longest(List61B<String> list) {
//        int maxDex = 0;
//        for (int i = 0; i < list.size(); i += 1) {
//            String longestString = list.get(maxDex);
//            String thisString = list.get(i);
//            if (thisString.length() > longestString.length()) {
//                maxDex = i;
//            }
//        }
//        return list.get(maxDex);
//    }
//
//    public static void main(String[] args) {
//        List61B<String> someList = new SLList<>();
//        someList.addLast("elk");
//        someList.addLast("are");
//        someList.addLast("watching");
//        System.out.println(longest(someList));
//    }
//
//}
/** Write a function that find the longest word from a list of words */
public class WordUtils {
    public static String findLongest(List61B<String> list){
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++){
            String longest = list.get(maxIndex);
            String cur = list.get(i);
            if (longest.length() < cur.length()){
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }

    public static void main(String[] args){
        List61B<String> someList = new SLList<>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(findLongest(someList));
    }
}














