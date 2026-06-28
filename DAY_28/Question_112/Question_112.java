// Write a program to Create contact management system.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_112 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        header("CONTACT MANAGEMENT SYSTEM");
        programStarter();
    }

    public static void header(String str) {
        System.out.println("============================================================");
        System.out.println("                " + str);
        System.out.println("============================================================");
    }

    public static void programStarter() {
        System.out.println("Hello ! What do you want today ?");
        while (true) {
            System.out.println("[1] Create new Account.");
            System.out.println("[2] Login my account");
            System.out.println("[3] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                loginAccount();
            } else if (choice == 3) {
                programExit();
            } else {
                System.out.println("Invalid choice ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static boolean userIdExist(int n) {
        try (BufferedReader br = new BufferedReader(new FileReader("userLogin.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (n == Integer.parseInt(data[0])) {
                    return true;
                }
            }

            return false;
        } catch (java.io.FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            System.out.println("Error Occured ! Try after sometime.");
            return false;
        }
    }

    public static void createAccount() {
        int userId;
        String password;
        while (true) {
            System.out.print("Enter a new USER-ID (Note : Should be a number): ");
            userId = sc.nextInt();
            if (userId <= 0) {
                System.out.println("USER-ID must be positive.");
                continue;
            }
            if (userIdExist(userId)) {
                System.out.println("This user-Id already exists. Please enter a new USER-ID");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter your PASSWORD : ");
            password = sc.next();

            if (password.length() < 6) {
                System.out.println("Password must contain at least 6 characters.");
                continue;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter your NAME : ");
        String name = sc.nextLine().trim();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userLogin.txt", true))) {
            writer.write(userId + "|" + password + "|" + name);
            writer.newLine();

            System.out.println("Congratulations ! Your profile created has been created successfully");
            System.out.println("---------------------------------------------------------------");
            System.out.println();
            return;
        } catch (Exception e) {
            System.out.println("Server Error Occured ! Please try after sometime.");
            System.out.println("Your Profile is not created.");
            return;
        }

    }

    public static void loginAccount() {

        int userId;
        while (true) {
            System.out.print("Enter USER-ID : ");
            userId = sc.nextInt();

            if (userId <= 0) {
                System.out.println("USER-ID must be positive.");
                continue;
            }
            break;
        }
        System.out.print("Enter your PASSWORD : ");
        String password = sc.next();
        try (BufferedReader br = new BufferedReader(new FileReader("userLogin.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 3)
                    continue;
                if (userId == Integer.parseInt(data[0])
                        && password.equals(data[1])) {

                    System.out.println("Successfully Logged In!");
                    System.out.println("Welcome, " + data[2] + "!");
                    postLogin(userId);
                    return;
                }
            }
            System.out.println("No such Account found!");
            System.out.println("Either your USER-ID or PASSWORD is incorrect.");

        } catch (Exception e) {
            System.out.println("Error finding your account. Please try again later.");
        }
    }

    public static void postLogin(int userId) {
        while (true) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("What do you want ?");
            System.out.println("[1] Create New Conatact");
            System.out.println("[2] Search a contact.");
            System.out.println("[3] Update a contact");
            System.out.println("[4] Delete a contact");
            System.out.println("[5] See all contacts");
            System.out.println("[6] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                createContact(userId);
            } else if (choice == 2) {
                searchContact(userId);
            } else if (choice == 3) {
                updateContact(userId);
            } else if (choice == 4) {
                deleteContact(userId);
            } else if (choice == 5) {
                listPrint(userId);
            } else if (choice == 6) {
                programExit();
            } else {
                System.out.println("Invalid Choice ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static boolean contactExist(int userId, String number) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(userId + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (number.equals(data[0])) {
                    return true;
                }
            }
            return false;
        } catch (java.io.FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            System.out.println("Error occurred while checking contacts.");
            return false;
        }
    }

    public static void createContact(int userId) {
        String num;
        String name;
        while (true) {
            System.out.print("Enter CONTACT NUMBER : ");
            num = sc.next();
            if (!num.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            if (contactExist(userId, num)) {
                System.out.println("This Contact Already Exists in your Contacts List.");
                continue;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter NAME : ");
        name = sc.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userId + ".txt", true))) {
            writer.write(num + "|" + name);
            writer.newLine();
            System.out.println("Contact saved successfully!");
            System.out.println("--------------------------------------------------");
            return;
        } catch (Exception e) {
            System.out.println("Server Error Occurred! Please try again later.");
            System.out.println("Contact was not saved.");
            return;
        }
    }

    public static void deleteContact(int userId) {
        String num;
        while (true) {
            System.out.print("Enter CONTACT NUMBER : ");
            num = sc.next();
            if (!num.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            if (!contactExist(userId, num)) {
                System.out.println("This Contact does not exist in your list.");
                return;
            }
            break;
        }

        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(userId + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (!num.equals(data[0])) {
                    records.add(line);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(userId + ".txt"))) {
                for (String record : records) {
                    bw.write(record);
                    bw.newLine();
                }
            }
            System.out.println("Contact deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting contact. Please try again later.");
        }
    }

    public static void updateContact(int userId) {
        String oldNumber;
        while (true) {
            System.out.print("Enter CONTACT NUMBER to update : ");
            oldNumber = sc.next();
            if (!oldNumber.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            if (!contactExist(userId, oldNumber)) {
                System.out.println("This Contact does not exist in your list.");
                return;
            }
            break;
        }

        String newNumber;
        while (true) {
            System.out.print("Enter NEW CONTACT NUMBER : ");
            newNumber = sc.next();
            if (!newNumber.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            if (!oldNumber.equals(newNumber) && contactExist(userId, newNumber)) {
                System.out.println("Another contact already uses this number.");
                continue;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter NEW CONTACT NAME : ");
        String newName = sc.nextLine().trim();
        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(userId + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (oldNumber.equals(data[0])) {
                    records.add(newNumber + "|" + newName);
                } else {
                    records.add(line);
                }
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any contacts saved yet.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading contacts.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userId + ".txt"))) {
            for (String record : records) {

                bw.write(record);
                bw.newLine();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Contact updated successfully!");
            System.out.println("New Number : " + newNumber);
            System.out.println("New Name   : " + newName);
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Error updating contact.");
        }
    }

    public static void searchContact(int userId) {
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Search by number.");
            System.out.println("[2] Search by name.");
            System.out.println("[3] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                searchByNumber(userId);
            } else if (choice == 2) {
                searchByName(userId);
            } else if (choice == 3) {
                programExit();
            } else {
                System.out.println("Invalid Choice ! Please re-enter your choice.");
                continue;
            }
        }

    }

    public static void searchByNumber(int userId) {
        System.out.println("------------------------------------------------------------");
        String num;
        while (true) {
            System.out.print("Enter CONTACT NUMBER : ");
            num = sc.next();
            if (!num.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            break;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(userId + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (num.equals(data[0])) {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Contact Found!");
                    System.out.println("Contact Number : " + data[0]);
                    System.out.println("Contact Name   : " + data[1]);
                    System.out.println("------------------------------------------------------------");
                    return;
                }
            }
            System.out.println("This Contact does not exist in your list.");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any contacts saved yet.");
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
        }
    }

    public static void searchByName(int userId) {
        System.out.println("------------------------------------------------------------");
        boolean found = false;
        sc.nextLine();
        System.out.print("Enter Contact's name : ");
        String name = sc.nextLine().trim();
        try (BufferedReader br = new BufferedReader(new FileReader(userId + ".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (data[1].trim().toLowerCase().contains(name.toLowerCase())) {
                    found = true;
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Contact Number : " + data[0]);
                    System.out.println("Contact Name   : " + data[1]);
                    System.out.println("------------------------------------------------------------");
                }
            }
            if (!found) {
                System.out.println("This Contact does not exist in your list.");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any contacts saved yet.");
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
        }
    }

    public static void listPrint(int userId) {
        header("ALL CONTACTS");
        System.out.printf("%-8s %-18s %-20s%n",
                "Sr No.", "Contact Number", "Contact Name");
        System.out.println("--------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader(userId + ".txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                found = true;
                System.out.printf("%-8d %-18s %-20s%n",
                        count, data[0], data[1]);
                count++;
            }
            if (!found) {
                System.out.println("No contacts found.");
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Total Contacts : " + (count - 1));
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any contacts saved yet.");
        } catch (Exception e) {
            System.out.println("Server Error! Please try again later.");
        }
    }

    public static void programExit() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Successfully Exited.");
        System.out.println("~ Developed by RAHUL GUPTA.");
        System.exit(0);
    }
}
