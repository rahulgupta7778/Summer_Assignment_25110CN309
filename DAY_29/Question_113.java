// Write a program to Create menu-driven calculator.

import java.util.Scanner;

public class Question_113 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("               JAVA CALCULATOR");
        System.out.println("=====================================================");
        inputTaker();
    }

    public static void inputTaker() {
        while (true) {
            System.out.println("Choose your operation : ");
            System.out.println("[1] Addition");
            System.out.println("[2] Subtraction");
            System.out.println("[3] Multiplication");
            System.out.println("[4] Division");
            System.out.println("[5] Square root");
            System.out.println("[6] Exponential");
            System.out.println("[7] Simple Interest");
            System.out.println("[8] Compound Interest");
            System.out.println("[9] Degree Celsius to Fahrenheit");
            System.out.println("[10] Degree Fahrenheit to Celsius");
            System.out.println("[11] Exit.");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    subtract();
                    break;
                case 3:
                    multiply();
                    break;
                case 4:
                    divide();
                    break;
                case 5:
                    squareRoot();
                    break;
                case 6:
                    exp();
                    break;
                case 7:
                    simpleInterest();
                    break;
                case 8:
                    compoundInterest();
                    break;
                case 9:
                    celToFah();
                    break;
                case 10:
                    fahToCel();
                    break;
                case 11:
                    System.out.println("\n~Successfully Exited.");
                    System.exit(0);
                default:
                    System.out.println("INVALID OPERATOR ! Please enter a valid operator.");
                    continue;
            }
        }
    }

    public static void add() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("               ADDITION");
        System.out.println("-----------------------------------------------------");
        int a, b;
        System.out.print("Input first number : ");
        a = sc.nextInt();
        System.out.print("Input second number : ");
        b = sc.nextInt();
        int result = a + b;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void subtract() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("               SUBTRACTION");
        System.out.println("-----------------------------------------------------");

        int a, b;
        System.out.print("Input first number : ");
        a = sc.nextInt();
        System.out.print("Input second number : ");
        b = sc.nextInt();
        int result = a - b;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void multiply() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("               MULTIPLICATION");
        System.out.println("-----------------------------------------------------");

        int a, b;
        System.out.print("Input first number : ");
        a = sc.nextInt();
        System.out.print("Input second number : ");
        b = sc.nextInt();
        long result = (long) a * b;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void divide() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              DIVISION");
        System.out.println("-----------------------------------------------------");

        double a, b;
        System.out.print("Input first number : ");
        a = sc.nextDouble();
        System.out.print("Input second number : ");
        b = sc.nextDouble();
        while (true) {
            if (b == 0) {
                System.out.println("Invalid input ! Please re-enter the second number : ");
                b = sc.nextDouble();
            } else {
                break;
            }
        }
        double result = a / b;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void squareRoot() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("             SQUARE ROOT");
        System.out.println("-----------------------------------------------------");
        System.out.print("Enter the number : ");
        double num = sc.nextDouble();

        if (num < 0) {
            System.out.println("Square root of a negative number is not possible.");
        } else {
            System.out.println("RESULT : " + Math.sqrt(num));
        }
        endChoice();
    }

    public static void exp() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              EXPONENTIAL");
        System.out.println("-----------------------------------------------------");
        double base, power;

        System.out.print("Enter base : ");
        base = sc.nextDouble();

        System.out.print("Enter power : ");
        power = sc.nextDouble();

        double result = Math.pow(base, power);
        System.out.println("RESULT ( " + base + "^" + power + " ) : " + result);
        endChoice();
    }

    public static void simpleInterest() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              SIMPLE INTEREST");
        System.out.println("-----------------------------------------------------");
        double principal, rate, time;
        while (true) {
            System.out.print("Enter principal value : ");
            principal = sc.nextDouble();
            System.out.print("Enter rate : ");
            rate = sc.nextDouble();
            System.out.print("Enter time (in years) : ");
            time = sc.nextDouble();
            if (principal > 0 && rate >= 0 && time >= 0) {
                break;
            } else {
                System.out.println("Invalid Input ! Please re-check your values and input again.");
                continue;
            }
        }
        double result = (principal * rate * time) / 100;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void compoundInterest() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              COMPOUND INTEREST");
        System.out.println("-----------------------------------------------------");
        double principal, rate, time;

        while (true) {
            System.out.print("Enter principal value : ");
            principal = sc.nextDouble();
            System.out.print("Enter rate : ");
            rate = sc.nextDouble();
            System.out.print("Enter time (in years) : ");
            time = sc.nextDouble();
            if (principal > 0 && rate >= 0 && time >= 0) {
                break;
            } else {
                System.out.println("Invalid Input ! Please re-check your values and input again.");
                continue;
            }
        }

        double result = principal * Math.pow((1 + rate / 100), time) - principal;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void celToFah() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              CELSIUS TO FAHRENHEIT");
        System.out.println("-----------------------------------------------------");
        double temp;
        System.out.print("Enter temperature in (CELSIUS) : ");
        temp = sc.nextDouble();
        double result = (temp * 9.0 / 5.0) + 32;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void fahToCel() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("              FAHRENHEIT TO CELSIUS");
        System.out.println("-----------------------------------------------------");

        double temp;
        System.out.print("Enter temperature in (Fahrenheit) : ");
        temp = sc.nextDouble();
        double result = (temp - 32) * 5.0 / 9.0;
        System.out.println("RESULT : " + result);
        endChoice();
    }

    public static void endChoice() {
        System.out.println("----------------------------------------------------");

        while (true) {
            System.out.println("=====================================================");
            System.out.println("What do you want next ? ");
            System.out.println("[1] Perform another operation.");
            System.out.println("[2] Exit.");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            if (choice == 1) {
                return;
            } else if (choice == 2) {
                System.out.println("\n~Successfully Exited.");
                System.exit(0);
            } else {
                System.out.println("Invalid Choice ! Please re-enter your choice.");
            }
        }
    }
}
