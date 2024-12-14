package Algorithm20241214;

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

    public static void main(String[] args) {
        Main main = new Main();
        //System.out.println(main.canJump(new int[]{2,3,1,1,4}));
        System.out.println(main.canJump(new int[]{3,2,1,0,4}));
    }
}
