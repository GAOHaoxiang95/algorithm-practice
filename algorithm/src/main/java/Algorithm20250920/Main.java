package Algorithm20250920;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> firstHalf= List.of('{', '[', '(');
        List<Character> secondHalf = List.of('}', ']', ')');

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstHalf.contains(c)) {
                stack.push(c);
            } else if (secondHalf.contains(c)) {
                if (stack.empty()) {
                    return false;
                } else {
                    Character peek = stack.peek();
                    if (firstHalf.contains(peek)) {
                        Character character = map.get(peek);
                        if (character.equals(c)){
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.isValid("()"));
        System.out.println(main.isValid("()[]{}"));
        System.out.println(main.isValid("(]"));
        System.out.println(main.isValid("([)]"));
        System.out.println(main.isValid("{[]}"));
    }
}
