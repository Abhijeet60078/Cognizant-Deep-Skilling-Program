public class FinancialForecasting {

    public static double futureValue(double amount, double growthRate, int years) {

        if (years == 0) {
            return amount;
        }

        return futureValue(amount, growthRate, years - 1)
                * (1 + growthRate / 100);
    }

    public static void main(String[] args) {

        double amount = 10000;
        double growthRate = 10;
        int years = 3;

        double result = futureValue(amount, growthRate, years);

        System.out.println("Future Value = " + result);
    }
}