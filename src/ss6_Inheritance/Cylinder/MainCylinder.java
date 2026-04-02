package ss6_Inheritance.Cylinder;

public class MainCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder(2.5);
        System.out.println(cylinder1);

        Cylinder cylinder2 = new Cylinder(2.2, "blue", 3.4);
        System.out.println(cylinder2);
    }
}
