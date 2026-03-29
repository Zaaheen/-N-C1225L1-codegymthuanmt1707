package ss4_class_and_object.ClassFan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setOn(true);
        fan1.setRadius(10);
        fan1.setColor("yellow");

        Fan fan2 = new Fan(Fan.MEDIUM, false, 5, "blue");

        System.out.println("Fan1: " + fan1.toString());
        System.out.println("Fan2: " + fan2.toString());
    }
}
