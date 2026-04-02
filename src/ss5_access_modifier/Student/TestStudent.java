package ss5_access_modifier.Student;

public class TestStudent {
    public static void main(String[] args) {
        Student st1 = new Student();
        System.out.println(st1);
        st1.setName("Thuan");
        st1.setClasses("C03");
        System.out.println(st1);

    }
}
