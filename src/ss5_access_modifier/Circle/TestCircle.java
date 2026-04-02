package ss5_access_modifier.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Radius c1: " + c1.getRadius());
        System.out.println("Area c1: " + c1.getArea());

        Circle c2 = new Circle(2.5, "blue");
        System.out.println("Radius c1:" + c2.getRadius());
        System.out.println("Area c1: " + c2.getArea());
    }
}
