package Algorithm20241203;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomNote.toCharArray()) {
            Integer orDefault = magazineMap.getOrDefault(c, -1);
            if (orDefault <= 0) {
                return false;
            }
            magazineMap.put(c, orDefault - 1);
        }

        return true;
    }

    public boolean canConstruct_official(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canConstruct("a", "b"));
        System.out.println(main.canConstruct("aa", "ab"));
        System.out.println(main.canConstruct("aa", "aab"));
    }
}
