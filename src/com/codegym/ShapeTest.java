package com.codegym;

public class ShapeTest {

//    public static void main(String[] args) {
//        Shape shape = new Shape();
//        System.out.println(shape);
//
//        shape = new Shape("red", false);
//        System.out.println(shape);
//    }
    public Shape[] createShapes(){
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(3.0,4.0);
        shapes[2] = new Square(5.0);
        return shapes;
    }
    public void displayAndResize(Shape[] shapes){
        for (Shape shape : shapes){ // Shape là kiểu dữ liệu đối tượng, shape là tên biến, shapes là tên mảng
            double areaBefore = getAreaOfShape(shape);
            double percent = Math.random() * 100 + 1;

            if (shape instanceof Resizeable){
                ((Resizeable) shape).resize(percent);
            }

            double areaAfter = getAreaOfShape(shape);

            printResult(shape,percent,areaBefore,areaAfter);
        }
    }
    private double getAreaOfShape(Shape shape){
        if (shape instanceof Circle){
            return ((Circle) shape).getArea(); // Ép kiểu
        } else if (shape instanceof Rectangle){ // Class Square là lớp con của Rectangle
            return  ((Rectangle) shape).getArea();
        }
        return 0;
    }
    private void printResult(Shape shape, double percent, double before, double after) {
        System.out.println("Hình: " + shape.getClass().getSimpleName());
        System.out.println("- Tỉ lệ tăng: " + Math.round(percent) + "%");
        System.out.println("- Diện tích trước: " + String.format("%.2f", before));
        System.out.println("- Diện tích sau: " + String.format("%.2f", after));
        System.out.println("-------------------------");
    }
}
