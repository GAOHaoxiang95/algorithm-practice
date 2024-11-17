package Algorithm20241117;

public class Main {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.trim().split(" ");
        return s1[s1.length-1].length();
    }


    public int lengthOfLastWord_official(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    public static void main(String[] args) {
        String[] s1 = " test    he   kil ".split(" ");
    }
}
