public class BicycleDemo {

    static class Bicycle {
        int speed = 0;

        void accelerate() {
            speed += 2;
        }

        void brake() {
            speed = Math.max(0, speed - 1);
        }
    }

    static class GearedBicycle extends Bicycle {
        void brake() {
            speed = Math.max(0, speed - 2);
        }
    }

    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        GearedBicycle g = new GearedBicycle();

        b.accelerate(); b.accelerate();
        g.accelerate(); g.accelerate();

        b.brake();
        g.brake();

        System.out.println("Regular: " + b.speed);
        System.out.println("Geared: " + g.speed);
    }
}