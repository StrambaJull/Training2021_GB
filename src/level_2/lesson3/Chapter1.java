package level_2.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Chapter1 {
    public static void MyArrayList() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("весна");
        arrayList.add("зима");
        arrayList.add("лето");
        arrayList.add("осень");
        arrayList.add("велосипед");
        arrayList.add("мотоцикл");
        arrayList.add("автомобиль");
        arrayList.add("электрокар");
        arrayList.add("дом");
        arrayList.add("квартира");
        arrayList.add("комната");
        arrayList.add("весна");
        arrayList.add("зима");
        arrayList.add("лето");
        arrayList.add("лето");
        arrayList.add("лето");
        arrayList.add("велосипед");
        arrayList.sort(Comparator.naturalOrder());
        System.out.println("arrayList: " + arrayList);
        System.out.println("arrayList size: " + arrayList.size());

        Set<String> setHashSet = new HashSet<>(arrayList);
        System.out.println("HashSet: " + setHashSet);
        System.out.println("HashSet size" + setHashSet.size());
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String n : setHashSet) {
            for (String m : arrayList) {
                if (n.equals(m)) {
                    count++;
                }
            }
            map.put(n, count);
            count = 0;
        }
        System.out.println("Результат map: " + map);
    }
}
