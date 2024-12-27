package Algorithm20241227;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<String> summaryRanges(int[] nums) {
        Integer starter = null;
        Integer cur = null;

        List<String> result = new ArrayList<>();
        for (int num : nums) {
            if (starter == null) {
                starter = num;
            }
            if (cur == null) {
                cur = num;
                starter = num;
            } else {
                cur = cur + 1;
                if (num != cur) {
                    if (starter.equals( cur - 1)) {
                        result.add(String.valueOf(starter));
                    } else {
                        result.add(starter + "->" + (cur - 1));
                    }
                    cur = num;
                    starter = num;
                }
            }
        }
        if (starter != null) {
            if (starter.equals( cur)) {
                result.add(String.valueOf(starter));
            } else {
                result.add(starter + "->" + cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(main.summaryRanges(nums));
    }
}
