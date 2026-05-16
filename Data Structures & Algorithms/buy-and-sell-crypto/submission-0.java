class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit =0;
        for(int i = 1;i<prices.length;i++){
            int currentProfit = prices[i] - minPrice; // finding the current profit b/w two indexes

            maxProfit = Math.max(maxProfit,currentProfit); // finding the total profit of entire array with in the journey 

            minPrice = Math.min(minPrice,prices[i]); // finding the current Minimus buying price
        }
        return maxProfit;
    }
}
