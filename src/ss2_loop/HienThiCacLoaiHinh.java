package ss2_loop;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        int choice;

        do {
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Enter height: ");
                    int height = scanner.nextInt();
                    System.out.println("Enter width: ");
                    int width = scanner.nextInt();

                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= height ; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:

                    System.out.println("1.Top-left");
                    System.out.println("2.Top-right");
                    System.out.println("3.Botton-left");
                    System.out.println("4.Botton_right");
                    choice = scanner.nextInt();

                    switch (choice){
                        case 1:
                            for (int i = 5; i >= 1 ; i--) {
                                for (int j = 1; j <= i ; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i = 1; i <= 5; i++) {
                                for (int j = 1; j < i ; j++) {
                                    System.out.print("  ");
                                }
                                for (int k = 1; k < 7 - i ; k++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (int i = 1; i <= 5 ; i++) {
                                for (int j = 1; j <= i ; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (int i = 1; i <= 5 ; i++) {
                                for (int j = 1; j <= 5 - i ; j++) {
                                    System.out.print("  ");
                                }
                                for (int k = 1; k <= i ; k++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 6 ; i++) {
                        for (int j = 1; j <= 6 - i ; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i ; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("The end.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Again");
            }
            System.out.println("--------------------------");
        } while (menu != 4);

    }
}
