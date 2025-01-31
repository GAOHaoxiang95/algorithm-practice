package Algorithm20250131;

import java.util.HashMap;

public class Main {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!indexMap.containsKey(num)) {
                indexMap.put(num, i);
            } else {
                Integer pos = indexMap.get(num);
                if (i - pos <= k) {
                    return true;
                } else {
                    indexMap.put(num, i);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
