public class Task3{
    public static void main(String[] args) {
        // --- Modify variables in the first section ---
        String a = "Wow";
        String b = a;
        String c = "Different";
        String d = "Wow!";

        // --- Do not modify below ---
        boolean b1 = a == b;            // true (both point to the same object "Wow")
        boolean b2 = d.equals(b + "!"); // true ("Wow!".equals("Wow!"))
        boolean b3 = !c.equals(a);      // true (!"Different".equals("Wow"))

        if (b1 && b2 && b3) {
            System.out.println("Success!"); 
        }
    }
}
