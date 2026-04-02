package ss6_Inheritance.Point;

import java.util.Arrays;

public class PointMain {
    public static void main(String[] args) {
        Point2D p2D = new Point2D();
        System.out.println(p2D);
        Point2D p2D1 = new Point2D(1.5f,5.1f);
        System.out.println(p2D1);
        float[] location = p2D1.getXY();
        System.out.println("Toạ độ của x là: " + location[0]);
        System.out.println("Toạ độ của y là: " + location[1]);

        Point3D p3D = new Point3D();
        System.out.println(p3D);
        Point3D p3D1 = new Point3D(1.2f,3.4f,5.6f);
        System.out.println(p3D1);
        float[] location3D = p3D1.getXYZ();
        System.out.println("Toạ độ của x là: " + location3D[0]);
        System.out.println("Toạ độ của y là: " + location3D[1]);
        System.out.println("Toạ độ của z là: " + location3D[2]);

        Point2D p3D2D = new Point3D(1.1f,2.2f, 3.3f); // Upcasting
        float[] location1 = ((Point3D)p3D2D).getXYZ(); // Downcasting
        System.out.println(Arrays.toString(location1));

    }
}
