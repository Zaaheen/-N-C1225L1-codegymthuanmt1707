package ss4_class_and_object;

import java.util.Scanner;

//public class PhuongTrinhBacHai {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Giải pt bậc 2: ax2 + bx + c = 0");
//        System.out.println("Nhập a: ");
//        double a = scanner.nextDouble();
//        System.out.println("Nhập b: ");
//        double b = scanner.nextDouble();
//        System.out.println("Nhập c: ");
//        double c = scanner.nextDouble();
//        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
//        double delta = quadraticEquation.getDiscriminant();
//
//
//        if (a == 0){
//            if ( b == 0){
//                if (c == 0){
//                    System.out.println("Phương trình có vô số nghiệm.");
//                } else {
//                    System.out.println("Phương trình vô nghiệm");
//                }
//            } else {
//                System.out.println("Phương trình có nghiệm x = " + quadraticEquation.x());
//            }
//        } else {
//            if (delta > 0){
//                System.out.println("Nghiệm x1 = " + quadraticEquation.getRoot1());
//                System.out.println("Nghiệm x2 = " + quadraticEquation.getRoot2());
//            } else if (delta == 0) {
//                System.out.println("Phương trình có nghiệm kép x1 = x2 = " + quadraticEquation.getRoot1());
//            } else {
//                System.out.println("Phương trình vô nghiệm.");
//            }
//        }
//    }
//}
//class QuadraticEquation {
//    private double a,b,c;
//
//    public QuadraticEquation(){
//
//    }
//    public QuadraticEquation(double a, double b, double c){
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }
//    public double getDiscriminant(){
//        return this.b * this.b - 4 * this.a * this.c;
//    }
//    public double getRoot1(){
//        double delta = getDiscriminant();
//        return (-this.b + Math.sqrt(delta)) / (2 * this.a);
//    }
//    public double getRoot2(){
//        double delta = getDiscriminant();
//        return (-this.b - Math.sqrt(delta)) / (2 * this.a);
//    }
//    public double x(){
//        return - this.c / this.b;
//    }
//}
