package Algorithm20241110;

public class Main {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        int expectedLength = nums.length;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                nums[j] = Integer.MAX_VALUE;
                expectedLength = expectedLength - 1;
            } else {
                i = j;
            }
        }

        int pos = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != Integer.MAX_VALUE) {
                nums[pos] = nums[j];
                pos++;
            }
        }
        return expectedLength;
    }

    public static int removeDuplicates_official(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 5, 5, 5, 6};
        int duplicates = removeDuplicates_official(a);

        System.out.println(duplicates);
        for (int i : a) {
            System.out.println(i);
        }
    }
}