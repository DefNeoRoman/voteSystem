package sandbox;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TMap {
    public static void main(String[] args) {
//        Map <Integer,String> map = new TreeMap<>((o1, o2) -> o2-o1);
//
//        map.put(1,"один");
//        map.put(2,"два");
//        map.put(3,"три");
//        map.put(4,"четыре");
//        map.put(5,"пять");
//        map.put(6,"шесть");
//
//        for (Map.Entry<Integer,String> entry: map.entrySet()){
//            System.out.println(entry.getKey());
//        }
        PriceComparator priceComparator = PriceComparator.getINSTANCE();
    }
}
