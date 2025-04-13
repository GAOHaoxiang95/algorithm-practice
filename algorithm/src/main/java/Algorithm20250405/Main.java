package Algorithm20250405;

import java.util.*;

public class Main {

    private static Map<String, String[]> result = Map.of(
            "2", new String[] {"a", "b", "c"},
            "3", new String[] {"d", "e", "f"},
            "4", new String[] {"g", "h", "i"},
            "5", new String[] {"j", "k", "l"},
            "6", new String[] {"m", "n", "o"},
            "7", new String[] {"p", "q", "r", "s"},
            "8", new String[] {"t", "u", "v"},
            "9", new String[] {"w", "x", "y", "z"}
    );

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String[]> combinations = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            Character a = digits.charAt(i);
            String[] strings = result.get(a.toString());
            combinations.add(strings);
        }

        List<String> results = new ArrayList<>();
        if (combinations.isEmpty()) {
            return new ArrayList<>();
        }

        String[] combination = combinations.get(0);
        for (String s : combination) {
            results.addAll(getCombo(s, combinations.subList(1, combinations.size())));
        }
        return results;
    }

    private List<String> getCombo(String s, List<String[]> strings) {
        if (strings.isEmpty()) {
            List<String> r = new ArrayList<>();
            r.add(s);
            return r;
        }
        if (strings.size() == 1) {
            String[] strings1 = strings.get(0);
            List<String> a = new ArrayList<>();
            for (String s1 : strings1) {
                a.add(s + s1);
            }
            return a;
        }
        List<String> results = new ArrayList<>();
        String[] combination = strings.get(0);
        for (String ss : combination) {
            results.addAll(getCombo(s + ss, strings.subList(1, strings.size())));
        }
        return results;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.letterCombinations("234"));
    }
}
