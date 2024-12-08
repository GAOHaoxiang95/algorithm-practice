package Algorithm20241208;

import java.util.HashMap;

public class Main {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.containsKey(si)) {
                Character character = map.get(si);
                if (character != ti) {
                    return false;
                }
            } else {
                map.put(si, ti);
            }
            if (map2.containsKey(ti)) {
                Character character = map2.get(ti);
                if (character != si) {
                    return false;
                }
            } else {
                map2.put(ti, si);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isIsomorphic("egg", "add"));
        System.out.println(main.isIsomorphic("foo", "bar"));
        System.out.println(main.isIsomorphic("paper", "title"));
    }
}
