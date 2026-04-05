package com.codegym;

public class Square extends Rectangle implements Resizeable{

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public void resize(double percent) {
        double newSide = getSide() * (1 + percent / 100);
        setSide(newSide);
    }

    @Override
    public String toString() {
        return "A Square with side = " + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
