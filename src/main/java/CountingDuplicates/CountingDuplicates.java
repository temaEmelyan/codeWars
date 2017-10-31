package CountingDuplicates;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

class CountingDuplicates {
    static int duplicateCount(final String text) {
        Collection<Long> values = text
                .codePoints()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values();

        return (int) values
                .stream()
                .filter(i -> i > 1)
                .count();
    }
}