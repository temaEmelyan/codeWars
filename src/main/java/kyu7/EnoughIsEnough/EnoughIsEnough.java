package kyu7.EnoughIsEnough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOcurrences) {
        //Code here ;)
        Map<Integer, Integer> occurrencesIntegerMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();


        for (int i = 0; i < elements.length; i++) {
            Integer orDefault = occurrencesIntegerMap.getOrDefault(elements[i], 0);
            if (orDefault < maxOcurrences) {
                orDefault++;
                occurrencesIntegerMap.put(elements[i], orDefault);
                answerList.add(elements[i]);
            }
        }

        int[] answerArray = new int[answerList.size()];

        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = answerList.get(i);
        }
        return answerList.stream().mapToInt(value -> value).toArray();
    }
}
