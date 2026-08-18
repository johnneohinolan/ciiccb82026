interface Animal {
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal {
    @Override
    public boolean feed(boolean timeToEat) {
        // put gorilla food into cage
        if (timeToEat) {
            System.out.println("put gorilla food into cage");
        }
        return timeToEat;
    }

    @Override
    public void groom() {
        // lather, rinse, repeat
        System.out.println("lather, rinse, repeat");
    }

    @Override
    public void pet() {
        // pet at your own risk
        System.out.println("pet at your own risk");
    }
}

public class Task16 {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla();
        gorilla.groom();
        gorilla.pet();
        gorilla.feed(true);
    }
}