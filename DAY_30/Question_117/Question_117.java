// Write a program to Create student record system using arrays and strings.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_117 {
    public static Scanner sc = new Scanner(System.in);

    public static String adm_dob;
    public static String stu_dob;
    public static int enrollNo;
    public static int admNo;

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("                  ABC PUBLIC SCHOOL                   ");
        System.out.println("           GREATER NOIDA (UTTAR PRADESH)              ");
        System.out.println("======================================================");
        System.out.println("      Welcome to Student Record management System     ");
        System.out.println("------------------------------------------------------");
        System.out.println();
        System.out.println();
        programStarter();
    }

    public static void header(String name) {
        System.out.println("======================================================");
        System.out.println("                " + name);
        System.out.println("------------------------------------------------------");
    }

    public static void programStarter() {
        while (true) {
            System.out.println("[1] Login as ADMIN.");
            System.out.println("[2] Login as STUDENT");
            System.out.println("[3] Exit");
            System.out.print("Choose your option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                adminLogin();
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

    public static void adminLogin() {
        header("ADMIN LOGIN WINDOW");

        while (true) {
            System.out.print("Enter your ENROLLMENT NUMBER : ");
            enrollNo = sc.nextInt();
            System.out.print("Enter your DATE OF BIRTH : ");
            adm_dob = sc.next();
            if (adminLoginChecker(enrollNo, adm_dob) == true) {
                System.out.println("Login Successful!");
                System.out.println("------------------------------------------------------");
                postLoginAdmin();
            } else {
                System.out.println("Failed to Login ! Invalid Credentials.");
                System.out.println("Try again.");
                continue;
            }
        }
    }

    public static void postLoginStudent() {

        while (true) {
            System.out.println("HELLO ! What do you want now?");
            System.out.println("[1] Check your Profile.");
            System.out.println("[2] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                infoChecker(admNo, stu_dob);
                System.out.println();
                System.out.println("------------------------------------------------------");
                System.out.println();
                System.out.println("What do want now?");
                System.out.println("[1] Exit.");
                System.out.print("Enter your choice : ");
                while (true) {
                    int ch2 = sc.nextInt();
                    if (ch2 == 1) {
                        programExit();
                        return;
                    } else {
                        System.out.println("Invalid Input ! Please re-enter your choice.");
                        continue;
                    }
                }

            } else if (choice == 2) {
                programExit();
                return;
            } else {
                System.out.println("Invalid input ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static void programExit() {
        System.out.println();
        System.out.println("Successfully Exited");
        System.out.println("~ Developed By RAHUL GUPTA.");
        System.exit(0);

    }

    public static boolean studentLoginChecker(int admNo, String dob) {
        try (BufferedReader br = new BufferedReader(new FileReader("studentLoginRecord.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

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

    public static void infoChecker(int admno, String dob) {

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");

                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = data[1];

                if (fileAdmNo == admno && fileDob.equals(dob)) {

                    found = true;

                    String fileStuName = data[2];
                    String fileClass = data[3];
                    int fileRollNo = Integer.parseInt(data[4]);
                    String fileGuardName = data[5];

                    System.out.println();
                    System.out.println("Hello ! " + fileStuName);
                    System.out.println("Admission Number : " + fileAdmNo);
                    System.out.println("Date of Birth : " + fileDob);
                    System.out.println("Guardian Name : " + fileGuardName);
                    System.out.println("Class\\Section : " + fileClass);
                    System.out.println("Roll Number : " + fileRollNo);

                    break;
                }
            }

            if (!found) {
                System.out.println("NO Record Found !");
            }

        } catch (Exception e) {
            System.out.println("SERVER Error Occurred ! Please try after sometime.");
        }
    }

    public static boolean adminLoginChecker(int enrollNo, String dob) {
        try (BufferedReader br = new BufferedReader(new FileReader("adminLoginRecord.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");

                int fileenrollNo = Integer.parseInt(data[0]);
                String fileDob = (data[1]);

                if (fileenrollNo == enrollNo && fileDob.equals(dob)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public static void postLoginAdmin() {
        while (true) {
            System.out.println("What do you want now?");
            System.out.println("[1] Add record");
            System.out.println("[2] Update record");
            System.out.println("[3] Delete record");
            System.out.println("[4] Exit");
            System.out.println();
            System.out.print("Choose your option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                recordAdder();
            } else if (choice == 2) {
                recordUpdate();
            } else if (choice == 3) {
                recordDelete();
            } else if (choice == 4) {
                programExit();
                return;
            } else {
                System.out.println("Invalid input ! Please re - enter your choice.");
                continue;
            }
        }
    }

    public static void recordAdder() {
        System.out.print("Enter student's Admission number : ");
        int admno = sc.nextInt();

        System.out.print("Enter Student's DOB : ");
        String dob = sc.next();

        ArrayList<String> studentRecords = new ArrayList<>();
        ArrayList<String> loginRecords = new ArrayList<>();

        try {
            try (BufferedReader br = new BufferedReader(
                    new FileReader("studentInfoRecord.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    int fileAdmno = Integer.parseInt(data[0]);

                    if (fileAdmno == admno) {
                        System.out.println(
                                "Failed to add record ! This student already exists.");
                        return;
                    }
                    studentRecords.add(line);
                }
            }
            try (BufferedReader br = new BufferedReader(
                    new FileReader("studentLoginRecord.txt"))) {

                String line;
                while ((line = br.readLine()) != null) {
                    loginRecords.add(line);
                }
            }
            sc.nextLine();
            System.out.print("Enter student's name : ");
            String stuname = sc.nextLine();
            System.out.print("Enter student's class [Like : 6th (A)] : ");
            String stuclass = sc.nextLine();
            System.out.print("Enter student's roll number : ");
            int sturoll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter student's Guardian name : ");
            String stuguad = sc.nextLine();
            studentRecords.add(
                    admno + "|" + dob + "|" + stuname + "|" +
                            stuclass + "|" + sturoll + "|" + stuguad);
            loginRecords.add(admno + " " + dob);
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("studentInfoRecord.txt"))) {

                for (String record : studentRecords) {
                    bw.write(record);
                    bw.newLine();
                }
            }
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("studentLoginRecord.txt"))) {

                for (String record : loginRecords) {
                    bw.write(record);
                    bw.newLine();
                }
            }
            System.out.println("Record added successfully.");
        } catch (Exception e) {
            System.out.println(
                    "Server Error Occured ! Please try after sometime.");
        }
    }

    public static void recordUpdate() {
        System.out.print("Enter student's Admission number : ");
        int admno = sc.nextInt();
        System.out.print("Enter Student's DOB : ");
        String dob = sc.next();
        boolean found = false;
        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmno = Integer.parseInt(data[0]);
                String fileDob = data[1];
                if (fileAdmno == admno && fileDob.equals(dob)) {
                    found = true;
                    sc.nextLine();
                    System.out.println("Current name : " + data[2]);
                    System.out.print("Enter new name : ");
                    String newName = sc.nextLine();
                    System.out.println("Current class : " + data[3]);
                    System.out.print("New Class/section [Like : 6th (B)] : ");
                    String newClass = sc.nextLine();
                    System.out.println("Current roll number : " + data[4]);
                    System.out.print("New Roll number : ");
                    int newRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Current Guardian name : " + data[5]);
                    System.out.print("New Guardian name : ");
                    String newGuad = sc.nextLine();
                    String newRecord = fileAdmno + "|" + fileDob + "|" + newName + "|" + newClass + "|" + newRoll + "|"
                            + newGuad;
                    records.add(newRecord);
                } else {
                    records.add(line);
                }
            }
            if (!found) {
                System.out.println("Student Record Not Found!");
                return;
            }
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("studentInfoRecord.txt"))) {

                for (String record : records) {
                    bw.write(record);
                    bw.newLine();
                }

                System.out.println("Record updated successfully.");
            }
        } catch (Exception e) {
            System.out.println("Server Error Occured ! Please try after sometime.");
        }

    }

    public static void recordDelete() {
        System.out.print("Enter student's Admission number : ");
        int admno = sc.nextInt();
        System.out.print("Enter Student's DOB : ");
        String dob = sc.next();
        boolean found = false, found2 = false;
        ArrayList<String> records = new ArrayList<>();
        ArrayList<String> loginInfo = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmno = Integer.parseInt(data[0]);
                String fileDob = data[1];
                if (fileAdmno == admno && fileDob.equals(dob)) {
                    found = true;
                    continue;
                } else {
                    records.add(line);
                }
            }
            if (!found) {
                System.out.println("Student Record Not Found!");
                return;
            }
            try (BufferedReader br2 = new BufferedReader(new FileReader("studentLoginRecord.txt"))) {
                String line2;
                while ((line2 = br2.readLine()) != null) {
                    String[] data2 = line2.split(" ");
                    int file2admno = Integer.parseInt(data2[0]);
                    String file2dob = data2[1];
                    if (file2admno == admno && file2dob.equals(dob)) {
                        found2 = true;
                        continue;
                    } else {
                        loginInfo.add(line2);
                    }
                }

                if (!found2) {
                    System.out.println("Student Login Record Not Found!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("An error occured in Login file ! Try again later.");
            }
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("studentInfoRecord.txt"))) {

                for (String record : records) {
                    bw.write(record);
                    bw.newLine();
                }
            }
            try (BufferedWriter bw2 = new BufferedWriter(
                    new FileWriter("studentLoginRecord.txt"))) {

                for (String loginrecord : loginInfo) {
                    bw2.write(loginrecord);
                    bw2.newLine();
                }
            }

            System.out.println("Record deleted successfully !");
        } catch (Exception e) {
            System.out.println("Server Error Occured ! Please try after sometime.");
        }

    }
}
