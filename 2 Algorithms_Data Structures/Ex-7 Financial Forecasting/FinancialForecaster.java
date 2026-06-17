import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    
    public static double forecastValueNaive(int year, double baseVal, double yearOneVal) {
        if (year == 0) return baseVal;
        if (year == 1) return yearOneVal;

        double previousYear = forecastValueNaive(year - 1, baseVal, yearOneVal);
        double twoYearsAgo = forecastValueNaive(year - 2, baseVal, yearOneVal);

        return (previousYear * 1.05) + (twoYearsAgo * 0.02);
    }

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double forecastValueOptimized(int year, double baseVal, double yearOneVal) {
        
        if (year == 0) return baseVal;
        if (year == 1) return yearOneVal;

      
        if (memo.containsKey(year)) {
            return memo.get(year); 
        }

        double previousYear = forecastValueOptimized(year - 1, baseVal, yearOneVal);
        double twoYearsAgo = forecastValueOptimized(year - 2, baseVal, yearOneVal);
        
        double result = (previousYear * 1.05) + (twoYearsAgo * 0.02);
        
     
        memo.put(year, result);
        return result;
    }

    public static void main(String[] args) {
        int targetYear = 30; 
        double startValue = 100000.0;
        double yearOneValue = 108000.0; 

        System.out.println("Financial Forecasting Tool");

        long startTimeOpt = System.nanoTime();
        double optimizedResult = forecastValueOptimized(targetYear, startValue, yearOneValue);
        long endTimeOpt = System.nanoTime();

        System.out.printf("Optimized Forecast (Year %d): $%,.2f\n", targetYear, optimizedResult);
        System.out.println("Time taken (Optimized): " + (endTimeOpt - startTimeOpt) / 1000000.0 + " ms\n");

        long startTimeNaive = System.nanoTime();
        double naiveResult = forecastValueNaive(targetYear, startValue, yearOneValue);
        long endTimeNaive = System.nanoTime();

        System.out.printf("Naive Forecast (Year %d): $%,.2f\n", targetYear, naiveResult);
        System.out.println("Time taken (Naive): " + (endTimeNaive - startTimeNaive) / 1000000.0 + " ms");
    }
}