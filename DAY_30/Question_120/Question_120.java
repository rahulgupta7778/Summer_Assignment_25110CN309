// Write a program to Develop complete mini project using arrays, strings and functions.

import java.io.*;
import java.util.*;

class SignUp {
    int userId;
    String password;
    String name;
}

class Date {
    int day;
    int month;
    int year;
}

class Plan {
    SignUp credentials;
    Date date;
    String plan;
}

public class Question_120 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        programStarter();
    }

    static void clearInput() {
        sc.nextLine();
    }

    static void programStarter() {
        int n = 0;
        System.out.println("\nWelcome! Enjoy your day.");
        System.out.println("\n1.NEW USER ! Get Registered");
        System.out.println("2.Login");
        System.out.println("3.Exit");
        System.out.print("Enter Your Choice here : ");
        n = sc.nextInt();

        switch (n) {
            case 1:
                registration();
                break;
            case 2:
                login();
                break;
            case 3:
                programExit();
                break;
            default:
                System.out.println("\nINVALID CHOICE!");
                programStarter();
                break;
        }
    }

    static boolean validDate(int d, int m, int y) {
        if (y < 1900 || m < 1 || m > 12 || d < 1)
            return false;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0))
            daysInMonth[1] = 29;

        return d <= daysInMonth[m - 1];
    }

    static void programExit() {
        System.out.println("\nSuccessfully Exited..");
        System.out.println("\n\n~ Developed by RAHUL GUPTA");
    }

    static void registration() {
        SignUp signup = new SignUp();
        System.out.print("\nEnter a USER ID (only numbers) :");
        signup.userId = sc.nextInt();
        clearInput();
        System.out.print("\nEnter a PASSWORD :");
        signup.password = sc.nextLine();
        System.out.print("\nEnter Your NAME here (only first name [CASE SENSITIVE]) : ");
        signup.name = sc.nextLine();

        try (FileWriter fw = new FileWriter("user_record.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(signup.userId + "|" + signup.password + "|" + signup.name);
        } catch (IOException e) {
            System.out.println("\nSORRY ! Server not working properly.");
            System.out.println("\nPlease try again later");
            programStarter();
            return;
        }

        System.out.println("\nCongratulations! You had successfully registered.");
        System.out.println("\nNote : Remember your NAME will be used as security question for login. It is CASE SENSITIVE.");
        System.out.println("\n\n=========================================================");
        int b = 0;
        System.out.println("\n1.Login");
        System.out.println("2.Exit");
        System.out.print("Enter your choice here : ");
        b = sc.nextInt();

        switch (b) {
            case 1:
                login();
                break;
            case 2:
                programExit();
                break;
            default:
                System.out.println("\nINVALID CHOICE !");
                programStarter();
                break;
        }
    }

    static void login() {
        SignUp login = new SignUp();
        System.out.print("\nUSER ID (only numbers) :");
        login.userId = sc.nextInt();
        clearInput();
        System.out.print("\nPASSWORD :");
        login.password = sc.nextLine();
        System.out.print("\nYour NAME here (only first name) : ");
        login.name = sc.nextLine();

        File file = new File("user_record.txt");
        if (!file.exists()) {
            System.out.println("\nSORRY ! Server not working properly.");
            System.out.println("\nPlease try again later");
            programStarter();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int uid = Integer.parseInt(parts[0]);
                    String pwd = parts[1];
                    String name = parts[2];
                    if (uid == login.userId && pwd.equals(login.password) && name.equals(login.name)) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                System.out.println("\nLogin successful!");
                postLoginAction(login);
            } else {
                System.out.println("\nNO USER FOUND ! Access Denied");
                programStarter();
            }
        } catch (IOException e) {
            System.out.println("\nSORRY ! Server not working properly.");
            System.out.println("\nPlease try again later");
            programStarter();
        }
    }

    static void postLoginAction(SignUp userCredential) {
        System.out.println("\nWELCOME " + userCredential.name);
        System.out.println("\n1.Add plan");
        System.out.println("2.Check Plan");
        System.out.println("3.Exit");
        int n = 0;
        System.out.print("Enter your choice : ");
        n = sc.nextInt();

        switch (n) {
            case 1:
                addPlan(userCredential);
                break;
            case 2:
                planChecker(userCredential);
                break;
            case 3:
                programExit();
                break;
            default:
                System.out.println("\nINVALID CHOICE! You had been logged out.");
                programStarter();
                break;
        }
    }

    static void addPlan(SignUp user) {
        Plan p = new Plan();
        p.credentials = user;
        p.date = new Date();

        while (true) {
            System.out.print("\nPlease enter the date here (DD MM YYYY): ");
            p.date.day = sc.nextInt();
            p.date.month = sc.nextInt();
            p.date.year = sc.nextInt();
            clearInput();

            if (!validDate(p.date.day, p.date.month, p.date.year)) {
                System.out.println("\nINVALID DATE! Please enter a valid date (DD MM YYYY).");
            } else {
                break;
            }
        }

        System.out.println("\nEnter your plan for the day:");
        p.plan = sc.nextLine();

        try (PrintWriter out = new PrintWriter(new FileWriter("plans.txt", true))) {
            out.printf("%d|%s|%s|%02d-%02d-%04d|%s\n",
                    p.credentials.userId,
                    p.credentials.password,
                    p.credentials.name,
                    p.date.day,
                    p.date.month,
                    p.date.year,
                    p.plan);
        } catch (IOException e) {
            System.out.println("\n\nSORRY ! Could not save plan.");
            postLoginAction(user);
            return;
        }

        System.out.println("\nPLAN SAVED successfully!");
        int b = 0;
        System.out.println("\n1.Add more plans");
        System.out.println("2.Check Plans");
        System.out.println("3.Exit");
        System.out.print("Enter your Choice: ");
        b = sc.nextInt();

        switch (b) {
            case 1:
                addPlan(user);
                break;
            case 2:
                planChecker(user);
                break;
            case 3:
                programExit();
                break;
            default:
                System.out.println("\nINVALID CHOICE!");
                postLoginAction(user);
                break;
        }
    }

    static void planChecker(SignUp user) {
        Plan p = new Plan();
        p.credentials = user;
        p.date = new Date();

        while (true) {
            System.out.print("\nPlease enter the date here (DD MM YYYY): ");
            p.date.day = sc.nextInt();
            p.date.month = sc.nextInt();
            p.date.year = sc.nextInt();
            clearInput();

            if (!validDate(p.date.day, p.date.month, p.date.year)) {
                System.out.println("\nINVALID DATE! Please enter a valid date (DD MM YYYY).");
            } else {
                break;
            }
        }

        File file = new File("plans.txt");
        if (!file.exists()) {
            System.out.println("\nSORRY ! Could not open plans file.");
            postLoginAction(user);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length < 5) continue;

                int uid = Integer.parseInt(parts[0]);
                String pwd = parts[1];
                String name = parts[2];
                String datePart = parts[3];
                String planText = parts[4];

                String[] dateParts = datePart.split("-");
                if (dateParts.length != 3) continue;

                int d = Integer.parseInt(dateParts[0]);
                int m = Integer.parseInt(dateParts[1]);
                int y = Integer.parseInt(dateParts[2]);

                if (uid == p.credentials.userId &&
                    pwd.equals(p.credentials.password) &&
                    name.equals(p.credentials.name) &&
                    d == p.date.day &&
                    m == p.date.month &&
                    y == p.date.year) {
                    if (!found) {
                        System.out.println("\nHere are your plans:");
                    }
                    found = true;
                    System.out.println(">): " + planText);
                }
            }

            if (!found) {
                System.out.println("\nNO PLANS FOUND for this date.");
            }

            System.out.println("\n\n======================================================");
            System.out.println("\n1.Check more plans");
            System.out.println("2.Add Plans");
            System.out.println("3.Exit");
            int b = 0;
            System.out.print("Enter your choice here : ");
            b = sc.nextInt();

            switch (b) {
                case 1:
                    planChecker(user);
                    break;
                case 2:
                    addPlan(user);
                    break;
                case 3:
                    programExit();
                    break;
                default:
                    System.out.println("INVALID CHOICE!");
                    postLoginAction(user);
                    break;
            }
        } catch (IOException e) {
            System.out.println("\nSORRY ! Could not open plans file.");
            postLoginAction(user);
        }
    }
}