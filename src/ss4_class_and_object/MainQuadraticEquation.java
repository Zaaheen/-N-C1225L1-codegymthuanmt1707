package ss4_class_and_object;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        System.out.println("Giải pt bậc 2: ax2 + bx + c = 0");
        QuadraticEquation equation = input();
        displayResult(equation);
    }
    public static QuadraticEquation input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter c: ");
        double c = Double.parseDouble(scanner.nextLine());
        return new QuadraticEquation(a,b,c);
    }
    public static void displayResult(QuadraticEquation equation){
        if (equation.getA() == 0) {
            if (equation.getB() == 0) {
                if (equation.getC() == 0) {
                    System.out.println("Infinite solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                System.out.println("The equation has one root");
                System.out.println("x = " + equation.x());
            }
        } else {
            double delta = equation.getDiscriminant();
            System.out.println("Delta =  " + delta);

            if (delta > 0 ){
                System.out.println("The equation has two distinct roots");
                System.out.println("x1 =  " + equation.root1());
                System.out.println("x2 =  " + equation.root2());
            } else if (delta == 0) {
                System.out.println("The equation has one root x = " + equation.root1());
            } else {
                System.out.println("No solution");
            }
        }
    }
}
