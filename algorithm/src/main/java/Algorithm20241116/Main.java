package Algorithm20241116;

// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000


public class Main {
    public int romanToInt(String s) {
        String one = "I";
        String five = "V";
        String ten = "X";
        String fifty = "L";
        String hundred = "C";
        String fiveHundred = "D";
        String thousand = "M";
        String four = "IV";
        String nine = "IX";
        String forty = "XL";
        String ninety = "XC";
        String fourHundred = "CD";
        String nineHundred = "CM";

        int result = 0;
        // 遍历字符串
        int i = 0;
        while (i < s.length() && i + 1 < s.length()) {
            String current = String.valueOf(s.charAt(i));
            String next = String.valueOf(s.charAt(i + 1));

            String combine = current + next;
            if (combine.equals(four)) {
                result += 4;
                i += 2;
            } else if (combine.equals(nine)) {
                result += 9;
                i += 2;
            } else if (combine.equals(forty)) {
                result += 40;
                i += 2;
            } else if (combine.equals(ninety)) {
                result += 90;
                i += 2;
            } else if (combine.equals(fourHundred)) {
                result += 400;
                i += 2;
            } else if (combine.equals(nineHundred)) {
                result += 900;
                i += 2;
            } else {
                if (current.equals(five)) {
                    result += 5;
                } else if (current.equals(ten)) {
                    result += 10;
                } else if (current.equals(fifty)) {
                    result += 50;
                } else if (current.equals(hundred)) {
                    result += 100;
                } else if (current.equals(fiveHundred)) {
                    result += 500;
                } else if (current.equals(thousand)) {
                    result += 1000;
                } else if (current.equals(one)) {
                    result += 1;
                }
                i++;
            }
        }

        if (s.length() == 1) {
            if (s.equals(five)) {
                result += 5;
            } else if (s.equals(ten)) {
                result += 10;
            } else if (s.equals(fifty)) {
                result += 50;
            } else if (s.equals(hundred)) {
                result += 100;
            } else if (s.equals(fiveHundred)) {
                result += 500;
            } else if (s.equals(thousand)) {
                result += 1000;
            } else if (s.equals(one)) {
                result += 1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.romanToInt("MCMXCIV"));
    }
}
