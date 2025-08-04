package Algorithm20250803;

import java.util.Arrays;

public class Main {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!Arrays.stream(bank).toList().contains(endGene)) {
            return -1;
        }
        char[] genes = {'A', 'C', 'G', 'T'};
        int count = 0;
        do {
            for (int i = 0; i < startGene.length(); i++) {
                char c = startGene.charAt(i);
                String prefixString = startGene.substring(0, i);
                String suffixString = startGene.substring(i + 1);

                boolean isFound = false;
                for (char gene : genes) {
                    if (gene != c) {
                        String newGene = prefixString + gene + suffixString;
                        if (Arrays.stream(bank).toList().contains(newGene)) {
                            isFound = true;
                            startGene = newGene;
                            count++;
                            break;
                        }
                    }
                }
                if (!isFound) {
                    return -1;
                }
            }
        } while (startGene != endGene);
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
    }
}
