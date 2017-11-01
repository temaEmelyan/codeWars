package SmileFaces;

import java.util.List;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        return (int) arr.stream().filter(s -> s.matches("[:;][-~]?[)D]")).count();

    }

    public static void main(String[] args) {
        System.out.println("xo)".matches("([:;])([-~])?([)]|[D])"));
    }

}
