package Algorithm20241214;

import java.util.HashMap;

public class Main {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > maxPos) {
                return false;
            }
            maxPos = nums[i] + i > maxPos ? nums[i] + i : maxPos;
            if(maxPos >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        HashMap<Character, String> mapping = new HashMap<>();
        HashMap<String, Character> reversedMapping = new HashMap<>();
        for (int i=0; i<pattern.length();i++) {
            char c = pattern.charAt(i);
            String s1 = split[i];

            if (mapping.containsKey(c)) {
                String s2 = mapping.get(c);
                if (!s1.equals(s2)) {
                    return false;
                }
            } else {
                if (reversedMapping.containsKey(s1)){
                    return false;
                }
                mapping.put(c, s1);
                reversedMapping.put(s1,c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        //System.out.println(main.canJump(new int[]{2,3,1,1,4}));
        //System.out.println(main.canJump(new int[]{3,2,1,0,4}));
        System.out.println(main.wordPattern("abba", "dog cat cat dog"));
        System.out.println(main.wordPattern("abba", "dog cat cat fish"));
        System.out.println(main.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(main.wordPattern("abba", "dog dog dog dog"));
    }
}
