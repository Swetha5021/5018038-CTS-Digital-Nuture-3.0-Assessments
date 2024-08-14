package com.finance.forecast;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Method to calculate future value using memoization
    public static double calculateFutureValue(double presentValue, double growthRate, int periods, Map<Integer, Double> memo) {
        // Check if the result is already computed
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

        // Base case: if there are no more periods, return the present value
        if (periods == 0) {
            return presentValue;
        }

        // Recursive case: calculate the future value for the next period
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1, memo);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 years

        Map<Integer, Double> memo = new HashMap<>();
        double futureValue = calculateFutureValue(presentValue, growthRate, periods, memo);
        System.out.println("Future Value: " + futureValue);
    }
}
