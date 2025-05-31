package Algorithm20250531;

public class Main {

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target <= num) {
                return i;
            }
            index = i;
        }
        return nums.length == 0 ? 0 : index + 1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.searchInsert(new int[] {2}, 1));
        System.out.println(main.searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(main.searchInsert(new int[] {1, 3, 5, 6}, 7));
    }
}
