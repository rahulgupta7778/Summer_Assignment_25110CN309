// Write a program to Create marksheet generation system.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question_108 {

    public static Scanner sc = new Scanner(System.in);

    public static String adm_dob;
    public static String stu_dob;
    public static int enrollNo;
    public static int admNo;
    public static int noOfSub;
    public static String[] subjects;

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
                return;
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
            if (studentLoginChecker(admNo, stu_dob)) {
                System.out.println("Login Successful!");
                System.out.println("------------------------------------------------------");
                postLoginStudent(admNo, stu_dob);
                return;
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
            if (adminLoginChecker(enrollNo, adm_dob)) {
                System.out.println("Login Successful!");
                System.out.println("------------------------------------------------------");
                postLoginAdmin();
                return;
            } else {
                System.out.println("Failed to Login ! Invalid Credentials.");
                System.out.println("Try again.");
                continue;
            }
        }
    }

    public static void adminOptions() {
        System.out.println("[1] Update Marks.");
        System.out.println("[2] Upload Marks.");
        System.out.println("[3] Delete Marks");
        System.out.println("[4] Exit.");
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

    public static void uploadMarks() {
        System.out.print("Enter Class (Like : 6A): ");
        String claSec = sc.next();
        claSec = claSec.toUpperCase();
        ArrayList<String> records = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(
                    new FileReader(claSec + "marks.txt"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    records.add(line);
                }
            } catch (Exception e) {
                System.out.println("First upload for this class, file will be created later.");
            }
            System.out.print("Enter the number of subjects in class : ");
            while (true) {
                noOfSub = sc.nextInt();

                if (noOfSub > 0)
                    break;

                System.out.print("Enter a valid number of subjects : ");
            }
            sc.nextLine();
            subjects = new String[noOfSub];
            System.out.println("Enter the name of subjects.");
            for (int i = 0; i < noOfSub; i++) {
                while (true) {
                    System.out.print("Enter subject " + (i + 1) + " : ");
                    subjects[i] = sc.nextLine().trim();

                    if (subjects[i].isEmpty()) {
                        System.out.println("Subject name cannot be empty.");
                        continue;
                    }

                    if (subjects[i].contains(":")) {
                        System.out.println("':' is not allowed in subject names.");
                        continue;
                    }

                    break;
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.print("Enter number of students in class : ");
            int stuCount;

            while (true) {
                stuCount = sc.nextInt();

                if (stuCount > 0)
                    break;

                System.out.print("Enter a valid student count : ");
            }
            ArrayList<String> newRecords = new ArrayList<>();
            for (int i = 0; i < stuCount; i++) {
                System.out.println();
                System.out.println("Student " + (i + 1));
                System.out.print("Admission Number : ");
                int admNo = sc.nextInt();
                System.out.print("DOB : ");
                String dob = sc.next();
                boolean recordFound = false;
                try (BufferedReader br = new BufferedReader(
                        new FileReader("studentInfoRecord.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split("\\|");
                        int fileAdmNo = Integer.parseInt(data[0]);
                        String fileDob = data[1];
                        String fileClass = data[3];
                        if (fileAdmNo == admNo
                                && fileDob.equals(dob)
                                && fileClass.equalsIgnoreCase(claSec)) {

                            recordFound = true;
                            break;
                        }
                    }

                }
                if (!recordFound) {
                    System.out.println(
                            "Failed Action! Student record not found in this class.");
                    continue;
                }
                boolean duplicate = false;
                for (String record : records) {
                    String[] data = record.split("\\|");
                    int fileAdmNo = Integer.parseInt(data[0]);
                    String fileDob = data[1];

                    if (fileAdmNo == admNo &&
                            fileDob.equals(dob)) {
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    for (String record : newRecords) {
                        String[] data = record.split("\\|");

                        int fileAdmNo = Integer.parseInt(data[0]);
                        String fileDob = data[1];

                        if (fileAdmNo == admNo &&
                                fileDob.equals(dob)) {

                            duplicate = true;
                            break;
                        }
                    }
                }
                if (duplicate) {
                    System.out.println(
                            "Marks already uploaded for this student.");
                    continue;
                }
                String newRecord = admNo + "|" + dob;
                int total = 0;
                for (int j = 0; j < noOfSub; j++) {
                    System.out.print(subjects[j] + " Marks : ");
                    while (true) {
                        int marks = sc.nextInt();

                        if (marks >= 0 && marks <= 100) {
                            total += marks;
                            newRecord += "|" + subjects[j] + ":" + marks;
                            break;
                        }

                        System.out.println(
                                "Invalid marks! Enter again.");
                    }
                }
                double percentage = (double) total / noOfSub;
                String grade = calculateGrade(percentage);
                newRecord += "|" + percentage + "|" + grade;
                newRecords.add(newRecord);
            }
            records.addAll(newRecords);
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter(claSec + "marks.txt"))) {
                for (String record : records) {

                    bw.write(record);
                    bw.newLine();
                }
            }
            System.out.println("Marks uploaded successfully!");
        } catch (Exception e) {
            System.out.println(
                    "Server Error! Please try after sometime.");
        }
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90)
            return "A (PASSED)";
        else if (percentage >= 80)
            return "B (PASSED)";
        else if (percentage >= 70)
            return "C (PASSED)";
        else if (percentage >= 60)
            return "D (PASSED)";
        else if (percentage >= 50)
            return "E (PASSED)";
        else
            return "F (FAIL)";
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

    public static void updateMarks() {
        System.out.print("Enter Class (Like : 6A) : ");
        String claSec = sc.next();
        claSec = claSec.toUpperCase();
        System.out.print("Enter Admission Number : ");
        int admNo = sc.nextInt();
        System.out.print("Enter DOB : ");
        String dob = sc.next();
        ArrayList<String> records = new ArrayList<>();
        boolean found = false;
        boolean recordFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                String filedob = data[1];
                String fileclasec = data[3];
                if ((fileAdmNo == admNo) && (filedob.equals(dob)) && (fileclasec.equalsIgnoreCase(claSec))) {
                    recordFound = true;
                    break;
                }
            }
            if (!recordFound) {
                System.out.println("Failed Action! Student record not found in this class.");
                return;

            }
        } catch (Exception e) {
            System.out.println("Error Occurred ! Please try after sometime.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(claSec + "marks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = data[1];
                if (fileAdmNo == admNo && fileDob.equals(dob)) {
                    found = true;
                    String newRecord = admNo + "|" + dob;
                    int total = 0;
                    int subjectCount = data.length - 4;
                    System.out.println("\nCurrent Marks:");
                    for (int i = 2; i < data.length - 2; i++) {
                        String[] subjectData = data[i].split(":");
                        String subjectName = subjectData[0];
                        String oldMarks = subjectData[1];
                        System.out.println(subjectName + " : " + oldMarks);
                        System.out.print("Enter new marks for "
                                + subjectName + " : ");
                        int newMarks;

                        while (true) {
                            newMarks = sc.nextInt();

                            if (newMarks >= 0 && newMarks <= 100) {
                                total += newMarks;
                                newRecord += "|" + subjectName + ":" + newMarks;
                                break;
                            }

                            System.out.println("Invalid marks! Enter again.");
                        }
                    }
                    double percentage = (double) total / subjectCount;
                    String grade = calculateGrade(percentage);
                    newRecord += "|" + percentage + "|" + grade;
                    records.add(newRecord);
                } else {
                    records.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Marks file not found.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return;
        }
        if (!found) {
            System.out.println("Student Record Not Found!");
            return;
        }
        try (FileWriter fw = new FileWriter(claSec + "marks.txt")) {

            for (String record : records) {
                fw.write(record + "\n");
            }

            System.out.println("\nMarks Updated Successfully!");

        } catch (Exception e) {
            System.out.println("Error updating file.");
        }
    }

    public static void deleteMarks() {
        System.out.print("Enter Class (Like : 6A) : ");
        String claSec = sc.next();
        claSec = claSec.toUpperCase();
        System.out.print("Enter Admission Number : ");
        int admNo = sc.nextInt();
        System.out.print("Enter DOB : ");
        String dob = sc.next();
        ArrayList<String> records = new ArrayList<>();
        boolean found = false;
        boolean recordFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                String filedob = data[1];
                String fileclasec = data[3];
                if ((fileAdmNo == admNo) && (filedob.equals(dob)) && (fileclasec.equalsIgnoreCase(claSec))) {
                    recordFound = true;
                    break;
                }
            }
            if (!recordFound) {
                System.out.println("Failed Action! Student record not found in this class.");
                return;

            }
        } catch (Exception e) {
            System.out.println("Error Occurred ! Please try after sometime.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(claSec + "marks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");
                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = data[1];
                if (fileAdmNo == admNo && fileDob.equals(dob)) {
                    found = true;
                    System.out.println();
                    System.out.println("Record Found:");
                    System.out.println(line);
                    continue;
                }
                records.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
            return;
        }
        if (!found) {
            System.out.println("Student Record Not Found!");
            return;
        }
        try (FileWriter fw = new FileWriter(claSec + "marks.txt")) {
            for (String record : records) {
                fw.write(record + "\n");
            }
            System.out.println("Record Deleted Successfully!");

        } catch (Exception e) {
            System.out.println("Error updating file.");
        }
    }

    public static void postLoginAdmin() {

        while (true) {
            System.out.println("HELLO ! What do you want now?");
            adminOptions();
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                updateMarks();
                System.out.println();
                System.out.println("------------------------------------------------------");
                System.out.println();
            } else if (choice == 2) {
                uploadMarks();
                System.out.println();
                System.out.println("------------------------------------------------------");
                System.out.println();
            } else if (choice == 3) {
                deleteMarks();
                System.out.println();
                System.out.println("------------------------------------------------------");
                System.out.println();
            } else if (choice == 4) {
                programExit();
            } else {
                System.out.println("Invalid input ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static void postLoginStudent(int admno, String dob) {

        while (true) {
            System.out.println("HELLO ! What do you want now?");
            System.out.println("[1] Check Your Marksheet.");
            System.out.println("[2] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                String fileClaSec = "";
                try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split("\\|");
                        int fileadmno = Integer.parseInt(data[0]);
                        String filedob = data[1];
                        if (fileadmno == admno && filedob.equals(dob)) {
                            fileClaSec = data[3];
                            fileClaSec = fileClaSec.toUpperCase();
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Server Error occurred ! Please try again after sometime.");
                }
                marksheetGenerator(admno, dob, fileClaSec);
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

    public static void marksheetGenerator(int admNo, String dob, String classSec) {
        String stuName = "";
        String stuClass = "";
        String guardianName = "";
        int rollNo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("studentInfoRecord.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");

                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = data[1];

                if (fileAdmNo == admNo && fileDob.equals(dob)) {

                    stuName = data[2];
                    stuClass = data[3];
                    rollNo = Integer.parseInt(data[4]);
                    guardianName = data[5];

                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Unable to fetch student details.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(classSec + "marks.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");

                int fileAdmNo = Integer.parseInt(data[0]);
                String fileDob = data[1];

                if (fileAdmNo == admNo && fileDob.equals(dob)) {
                    System.out.println("======================================================");
                    System.out.println("                  ABC PUBLIC SCHOOL                   ");
                    System.out.println("           GREATER NOIDA (UTTAR PRADESH)              ");
                    System.out.println("======================================================");
                    System.out.println("                     MARKSHEET                        ");
                    System.out.println("------------------------------------------------------");
                    System.out.println("Name          : " + stuName);
                    System.out.println("Admission No. : " + admNo);
                    System.out.println("Class         : " + stuClass);
                    System.out.println("Roll Number   : " + rollNo);
                    System.out.println("Guardian Name : " + guardianName);
                    System.out.println("Date of Birth : " + dob);
                    System.out.println("------------------------------------------------------");
                    System.out.println("SUBJECTS AND MARKS");
                    System.out.println("------------------------------------------------------");

                    for (int i = 2; i < data.length - 2; i++) {

                        String[] subjectData = data[i].split(":");

                        System.out.printf("%-15s : %s%n",
                                subjectData[0],
                                subjectData[1]);
                    }

                    System.out.println("------------------------------------------------------");
                    System.out.println("Percentage    : " + data[data.length - 2]);
                    System.out.println("Grade         : " + data[data.length - 1]);
                    System.out.println("======================================================");

                    return;
                }
            }

            System.out.println("Record Not Found!");

        } catch (FileNotFoundException e) {
            System.out.println("Marksheet record file not found.");
        } catch (Exception e) {
            System.out.println("Unable to generate marksheet.");
        }
    }
}