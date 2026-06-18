class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int stepMinus2 = 1;
        int stepMinus1 = 2;
        int current = 0;
        for (int i = 3; i <= n; i++){
            current = stepMinus1 + stepMinus2;
            stepMinus2 = stepMinus1;
            stepMinus1 = current;
        }
        return current;
    }
}
