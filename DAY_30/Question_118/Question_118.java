// Write a program to Create mini library system.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_118 {
    public static Scanner sc = new Scanner(System.in);
    public static String stu_dob;
    public static int admNo;

    public static void main(String[] args) {
        header("LIBRARY MANAGEMENT SYSTEM");
        programStarter();
    }

    public static void header(String str) {
        System.out.println("============================================================");
        System.out.println("                " + str);
        System.out.println("============================================================");
    }

    public static void programStarter() {
        System.out.println("------------------------------------------------------------");
        while (true) {
            System.out.println("[1] Login as ADMIN.");
            System.out.println("[2] Login as STUDENT");
            System.out.println("[3] Exit");
            System.out.print("Choose your option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter ADMIN ID : ");
                int accNo = sc.nextInt();
                if (accNo == 192837465) { // Secret Admin ID
                    postAdminLogin();
                    return;
                } else {
                    System.out.println("Access Denied!");
                }
            } else if (choice == 2) {
                studentLogin();
            } else if (choice == 3) {
                programExit();
            } else {
                System.out.println("Invalid Input ! Please enter a valid input.");
                continue;
            }
        }
    }

    public static void studentLogin() {
        header("STUDENT LOGIN WINDOW");
        while (true) {
            System.out.print("Enter your ADMISSION NUMBER : ");
            admNo = sc.nextInt();
            System.out.print("Enter your DATE OF BIRTH : ");
            stu_dob = sc.next();
            if (studentLoginChecker(admNo, stu_dob) == true) {
                System.out.println("Login Successful!");
                System.out.println("------------------------------------------------------");
                postLoginStudent();
            } else {
                System.out.println("Failed to Login ! Invalid Credentials.");
                System.out.println("Try again.");
                continue;
            }
        }
    }

    public static boolean studentLoginChecker(int admNo, String dob) {
        try (BufferedReader br = new BufferedReader(new FileReader("studentRecord.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = (data[1]);

                if (fileAdmNo == admNo && fileDob.equals(dob)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public static void postLoginStudent() {

        while (true) {
            System.out.println("============================================================");
            System.out.println("HELLO ! What do you want now?");
            System.out.println("[1] Check your Profile.");
            System.out.println("[2] Issue a Book.");
            System.out.println("[3] Return a Book.");
            System.out.println("[4] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                infoChecker(admNo, stu_dob);
            } else if (choice == 2) {
                issueBook(admNo, stu_dob);
            } else if (choice == 3) {
                returnBook(admNo, stu_dob);
            } else if (choice == 4) {
                programExit();
            } else {
                System.out.println("Invalid input ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static void infoChecker(int admno, String dob) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader("studentRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (admno == Integer.parseInt(data[0]) && dob.equals(data[1])) {
                    found = true;
                    header("STUDENT PROFILE");
                    System.out.println("Name : " + data[2]);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("                     BOOKS ISSUED");
                    System.out.println("------------------------------------------------------------");
                    ArrayList<String> books = getCurrentIssuedBooks(admno);
                    System.out.printf(
                            "%-12s %-30s %-20s%n",
                            "ISBN",
                            "BOOK NAME",
                            "DATE ISSUED");
                    System.out.println("------------------------------------------------------------");
                    if (books.isEmpty()) {
                        System.out.println("No issued books found!");
                    } else {
                        for (String record : books) {
                            String[] data1 = record.split("\\|");
                            System.out.printf(
                                    "%-12s %-30s %-20s%n",
                                    data1[1],
                                    data1[2],
                                    data1[3]);
                            System.out.println("------------------------------------------------------------");

                        }
                    }
                }
            }
            if (!found) {
                System.out.println("NO Record Found !");
            }
        } catch (Exception e) {
            System.out.println("SERVER Error Occurred ! Please try after sometime.");
        }
    }

    public static boolean bookExists(int isbn) {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (isbn == Integer.parseInt(data[0])) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading books file.");
        }

        return false;
    }

    public static boolean bookAvailable(int isbn) {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (isbn == Integer.parseInt(data[0])) {
                    return Integer.parseInt(data[2]) > 0;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading books file.");
        }

        return false;
    }

    public static String bookName(int isbn) {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (isbn == Integer.parseInt(data[0])) {
                    return data[1];
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void bookCountUpdate(int isbn, String action) {
        int count;
        ArrayList<String> record = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                count = Integer.parseInt(data[2]);
                if (isbn == Integer.parseInt(data[0])) {
                    if (action.equals("ISSUE") && count > 0) {
                        count--;
                    } else if (action.equals("RETURN")) {
                        count++;
                    }
                    record.add(isbn + "|" + data[1] + "|" + count);
                } else {
                    record.add(line);
                }
            }

            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("books.txt"))) {

                for (String record1 : record) {
                    bw.write(record1);
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void issueBook(int admno, String dob) {
        int isbn;
        while (true) {
            System.out.print("Enter the book ISBN : ");
            isbn = sc.nextInt();
            if (isbn < 0) {
                System.out.println("Invalid ISBN number ! Please enter a valid number.");
                continue;
            }
            if (!bookExists(isbn)) {
                System.out.println("Book does not exist.");
            } else if (!bookAvailable(isbn)) {
                System.out.println("Book currently unavailable.");
            } else {
                break;
            }
        }
        if (isBookIssuedToStudent(admno, isbn)) {
            System.out.println("You have already issued this book.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("issueHistory.txt", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String dateTime = now.format(formatter);
            bw.write(admno + "|" + isbn + "|" + bookName(isbn) + "|" + dateTime + "|ISSUED");
            bw.newLine();
            bookCountUpdate(isbn, "ISSUE");
            System.out.println("Book Issued Successfully.");
            System.out.println("------------------------------------------------------");
            return;
        } catch (Exception e) {
            System.out.println("Error Issuing Book ! Please try after sometime.");
            return;
        }
    }

    public static boolean isBookIssuedToStudent(int admNo, int isbn) {
        boolean issued = false;
        try (BufferedReader br = new BufferedReader(new FileReader("issueHistory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                int fileIsbn = Integer.parseInt(data[1]);
                String status = data[4];
                if (fileAdmNo == admNo && fileIsbn == isbn) {
                    if (status.equals("ISSUED")) {
                        issued = true;
                    } else if (status.equals("RETURNED")) {
                        issued = false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading issue history.");
        }
        return issued;
    }

    public static ArrayList<String> getCurrentIssuedBooks(int admNo) {
        ArrayList<String> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("issueHistory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                int isbn = Integer.parseInt(data[1]);
                String status = data[4];
                if (fileAdmNo == admNo) {
                    if (status.equals("ISSUED")) {
                        books.add(line);
                    } else if (status.equals("RETURNED")) {
                        for (int i = 0; i < books.size(); i++) {
                            String[] temp = books.get(i).split("\\|");
                            if (isbn == Integer.parseInt(temp[1])) {
                                books.remove(i);
                                break;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading issue history.");
        }

        return books;
    }

    public static void returnBook(int admno, String dob) {
        int isbn;
        while (true) {
            System.out.print("Enter the book ISBN : ");
            isbn = sc.nextInt();
            if (isbn < 0) {
                System.out.println("Invalid ISBN number ! Please enter a valid number.");
                continue;
            } else if (bookExists(isbn)) {
                break;
            } else {
                System.out.println("No such Book found!");
                continue;
            }
        }

        if (!isBookIssuedToStudent(admno, isbn)) {
            System.out.println("This book is not issued to you.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("issueHistory.txt", true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String dateTime = now.format(formatter);
            bw.write(admno + "|" + isbn + "|" + bookName(isbn) + "|" + dateTime + "|RETURNED");
            bw.newLine();
            bookCountUpdate(isbn, "RETURN");
            System.out.println("Book Returned Successfully.");
            System.out.println("------------------------------------------------------");
            return;
        } catch (Exception e) {
            System.out.println("Error Returning Book ! Please try after sometime.");
            return;
        }
    }

    public static void postAdminLogin() {
        while (true) {
            System.out.println("============================================================");
            System.out.println("[1] Add Book");
            System.out.println("[2] Update Book record");
            System.out.println("[3] View Book's List");
            System.out.println("[4] View Book Issue History");
            System.out.println("[5] View Current Holders");
            System.out.println("[6] Exit");
            System.out.println();
            System.out.print("Choose your option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                recordAdder();
            } else if (choice == 2) {
                recordUpdate();
            } else if (choice == 3) {
                listPrint();
            } else if (choice == 4) {
                bookIssueHistory();
            } else if (choice == 5) {
                currentBookHolders();
            } else if (choice == 6) {
                programExit();
            } else {
                System.out.println("Invalid input !");
            }
        }
    }

    public static void recordAdder() {
        int isbn;
        while (true) {
            System.out.print("Enter the book ISBN : ");
            isbn = sc.nextInt();
            if (isbn < 0) {
                System.out.println("Invalid ISBN number ! Please enter a valid number.");
                continue;
            }
            if (!bookExists(isbn)) {
                break;
            } else {
                System.out.println("This book already exists.");
                return;
            }
        }
        System.out.print("Enter book name : ");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.print("Enter available copies of book : ");
        int copies = sc.nextInt();
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("books.txt", true))) {
            bw.write(isbn + "|" + bookName + "|" + copies);
            bw.newLine();
            System.out.println("Record added successfully.");

        } catch (Exception e) {
            System.out.println(
                    "Server Error Occurred ! Please try after sometime.");
        }
    }

    public static void recordUpdate() {
        int isbn;
        while (true) {
            System.out.print("Enter the book ISBN : ");
            isbn = sc.nextInt();
            if (isbn < 0) {
                System.out.println("Invalid ISBN number ! Please enter a valid number.");
                continue;
            }
            if (bookExists(isbn)) {
                break;
            } else {
                System.out.println("This book does not exists.");
                return;
            }
        }
        System.out.print("Enter new book name : ");
        sc.nextLine();
        String bookName = sc.nextLine();
        System.out.print("Enter new available copies of book : ");
        int copies = sc.nextInt();
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            ArrayList<String> newRecord = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (isbn == Integer.parseInt(data[0])) {
                    newRecord.add(isbn + "|" + bookName + "|" + copies);
                } else {
                    newRecord.add(line);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))) {
                for (String string : newRecord) {
                    bw.write(string);
                    bw.newLine();
                }
                System.out.println("Record Updated successfully!");
                return;
            } catch (Exception e) {
                System.out.println("Error Occurred ! Record not updated.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
            return;
        }

    }

    public static void listPrint() {
        header("ALL BOOKS");
        System.out.printf(
                "%-8s %-18s %-25s %-15s%n",
                "Sr No.",
                "ISBN Number",
                "Book Name",
                "Copies");
        System.out.println("--------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 3)
                    continue;
                found = true;
                System.out.printf(
                        "%-8d %-18s %-25s %-15s%n",
                        count,
                        data[0],
                        data[1],
                        data[2]);
                count++;
            }
            if (!found) {
                System.out.println("No books found.");
            } else {
                System.out.println("--------------------------------------------------");
                System.out.println("Total BOOKS : " + (count - 1));
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any books saved yet.");
        } catch (Exception e) {
            System.out.println("Server Error! Please try again later.");
        }
    }

    public static void bookIssueHistory() {
        System.out.print("Enter Book ISBN : ");
        int isbn = sc.nextInt();

        if (!bookExists(isbn)) {
            System.out.println("Book does not exist.");
            return;
        }

        header("BOOK ISSUE HISTORY");
        System.out.println("Book Name : " + bookName(isbn));
        System.out.println();
        System.out.printf(
                "%-12s %-30s %-22s %-12s%n",
                "ADM NO",
                "BOOK NAME",
                "DATE",
                "STATUS");

        System.out.println(
                "--------------------------------------------------------------------------");

        boolean found = false;
        try (BufferedReader br = new BufferedReader(
                new FileReader("issueHistory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (isbn == Integer.parseInt(data[1])) {
                    found = true;
                    System.out.printf(
                            "%-12s %-30s %-22s %-12s%n",
                            data[0],
                            data[2],
                            data[3],
                            data[4]);
                }
            }
            if (!found) {
                System.out.println("No issue history found.");
            }
        } catch (Exception e) {
            System.out.println("Error reading issue history.");
        }
    }

    public static void currentBookHolders() {
        System.out.print("Enter Book ISBN : ");
        int isbn = sc.nextInt();
        if (!bookExists(isbn)) {
            System.out.println("Book does not exist.");
            return;
        }
        header("CURRENT BOOK HOLDERS");
        System.out.println("Book Name : " + bookName(isbn));
        System.out.println(
                "------------------------------------------------------------");
        System.out.printf(
                "%-15s %-25s%n",
                "ADM NO",
                "STATUS");
        System.out.println(
                "------------------------------------------------------------");
        boolean found = false;

        try (BufferedReader br = new BufferedReader(
                new FileReader("studentRecord.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int studentAdmNo = Integer.parseInt(data[0]);
                if (isBookIssuedToStudent(studentAdmNo, isbn)) {
                    found = true;
                    System.out.printf(
                            "%-15d %-25s%n",
                            studentAdmNo,
                            "CURRENTLY ISSUED");
                }
            }
            if (!found) {
                System.out.println("No student currently holds this book.");
            }
        } catch (Exception e) {
            System.out.println("Error reading records.");
        }
    }

    public static void programExit() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Successfully Exited.");
        System.out.println("~ Developed by RAHUL GUPTA.");
        System.exit(0);
    }
}
