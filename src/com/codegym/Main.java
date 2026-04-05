package com.codegym;

public class Main {
    public static void main(String[] args) {
        ShapeTest test = new ShapeTest();
        Shape[] myShapes = test.createShapes();
        test.displayAndResize(myShapes);
    }
}
