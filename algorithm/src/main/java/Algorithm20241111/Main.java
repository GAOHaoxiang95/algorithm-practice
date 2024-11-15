package Algorithm20241111;

public class Main {

    // timeout solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        if (gas.length != cost.length) return -1;

        for (int i = 0; i < gas.length; i++) {
            int tank = 0;
            int j = i;
            while (tank >= 0) {
                tank += gas[j];
                tank -= cost[j];
                j = (j + 1) % gas.length;
                if (j == i && tank >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Main m = new Main();
        System.out.println(m.canCompleteCircuit(gas, cost));
    }
}
