public class Task2 {
    public static void main(String[] args) {
        // Declaring all required primitives with distinct values
        char character = 'H';
        byte zero = 0;
        short one = 1;
        int number = 3110;
        float floatNum = 2.0f;
        boolean boolVal = true;

        // Concatenating primitives with literal strings to form the target output
        String output = "" + character + number + " w" + zero + "r" + one + "d " + floatNum + " " + boolVal;

        // Printing the result
        System.out.println(output);
    }
}