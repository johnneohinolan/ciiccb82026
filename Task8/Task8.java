public class Task8 {

    public static int calculateCumulativeSums(int... numbers) {
        int totalSum = 0;

        for (int num : numbers) {
            int cumulativeSum = 0;
            for (int i = 1; i <= num; i++) {
                cumulativeSum += i;
            }

            System.out.println("Cumulative sum for " + num + " = " + cumulativeSum);
            
            totalSum += cumulativeSum;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int result = calculateCumulativeSums(4, 5, 10);
        
        System.out.println("----------------------------");
        System.out.println("Total sum of all parameters: " + result);
    }
}