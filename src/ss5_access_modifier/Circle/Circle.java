package ss5_access_modifier.Circle;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0){
            this.radius = radius;
        }
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
}
