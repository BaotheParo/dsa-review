class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length){
            if (prices[left] < prices[right]){
                int currentProfit = prices[right] - prices[left];
                if(currentProfit > maxProfit){
                    maxProfit = currentProfit;
                }
            }
            else{
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
