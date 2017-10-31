package DuplicateEncoder;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    static String encode(String word) {

        Map<Character, Long> collect = word.toLowerCase().chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (collect.get(word.toLowerCase().charAt(i)) > 1) {
                stringBuilder.append(")");
            } else {
                stringBuilder.append("(");
            }
        }

        return stringBuilder.toString();
    }
}
