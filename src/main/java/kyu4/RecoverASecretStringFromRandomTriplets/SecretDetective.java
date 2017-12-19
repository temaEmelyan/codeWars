package kyu4.RecoverASecretStringFromRandomTriplets;

import java.util.*;

public class SecretDetective {
    public String recoverSecret(char[][] triplets) {
        Set<Character> characters = new HashSet<>();

        for (char[] triplet : triplets) {
            for (char c : triplet) {
                characters.add(c);
            }
        }

        Character[] characters1 = characters.toArray(new Character[]{});

//        Comparator<Character> characterComparator = (o1, o2) -> 0;
//
//        for (char[] triplet : triplets) {
//            ArrayList<Character> tripl = new ArrayList<>();
//            for (char c : triplet) {
//                tripl.add(c);
//            }
//
//            characterComparator = characterComparator.thenComparing((o1, o2) -> {
//                if (!tripl.contains(o1) || !tripl.contains(o2)) {
//                    return 0;
//                }
//                return Integer.compare(tripl.indexOf(o1), tripl.indexOf(o2));
//            });
//        }
//
//        Arrays.sort(characters1, characterComparator);

//        Comparator[] characterComparators = new Comparator[triplets.length];

        ArrayList<Comparator<Character>> characterComparators = new ArrayList<>();

        for (char[] triplet : triplets) {

            ArrayList<Character> tripl = new ArrayList<>();
            for (char c : triplet) {
                tripl.add(c);
            }

            characterComparators.add((o1, o2) -> {
                if (!tripl.contains(o1) || !tripl.contains(o2)) {
                    return 0;
                }
                return Integer.compare(tripl.indexOf(o1), tripl.indexOf(o2));
            });
        }


        for (Comparator<Character> characterComparator : characterComparators) {
            Arrays.sort(characters1, characterComparator);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Character character : characters1) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
