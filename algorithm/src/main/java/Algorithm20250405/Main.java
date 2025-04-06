package Algorithm20250405;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (int i = 0; i < digits.length(); i++) {
            Character a = digits.charAt(0);
            String[] strings = result.get(a.toString());

            for (String string : strings) {

            }
        }
        return new ArrayList<>();
    }
}
