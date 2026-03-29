package ss4_class_and_object;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant(){
        return this.b * this.b - 4 * this.a * this.c;
    }
    public double root1(){
        double delta = getDiscriminant();
        return (-this.b + Math.sqrt(delta)) / (2 * this.a);
    }
    public double root2(){
        double delta = getDiscriminant();
        return (-this.b - Math.sqrt(delta)) / (2 * this.a);
    }
    public double x(){
        return - this.c / this.b;
    }
}
