package Algorithm20250202;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public boolean isHappy(int n) {

        Set<Integer> a = new HashSet<>();

        do {
            int i = computeSquare(n);
            if (i == 1) {
                return true;
            }
            if (a.contains(i)) {
                return false;
            }
            a.add(i);
            n = i;
        } while (true);
    }

    private int computeSquare(int n) {
        String numberString = String.valueOf(n);
        int v = 0;
        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            int value = c - '0';
            v = value * value + v;
        }
        return v;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isHappy(19));

    }
}
