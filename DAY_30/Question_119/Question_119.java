// Write a program to Create mini employee management system.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_119 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("               EMPLOYEE MANAGEMENT SYSTEM             ");
        System.out.println("======================================================");
        userSide();
        return;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void empLogin() {
        System.out.println("------------------------------------------------------");
        System.out.print("Enter your ID : ");
        int id = sc.nextInt();
        System.out.print("Enter your password : ");
        String password = sc.next();
        String hashedInputPassword = hashPassword(password);
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (id == Integer.parseInt(data[0]) && hashedInputPassword.equals(data[2])) {
                    found = true;
                    System.out.println("Successfully Logged in.");
                    postEmpLogin(id);
                    break;
                }
            }
            if (!found) {
                System.out.println("Access Denied ! NO such account found.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Server error ! Please try after sometime.");
            return;
        }
    }

    public static void postEmpLogin(int id) {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("[1] Mark your Attendance");
            System.out.println("[2] Change your Password");
            System.out.println("[3] Check your Profile");
            System.out.println("[4] Check your Salary slip");
            System.out.println("[5] Log Out");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                markAttendance(id);
            } else if (choice == 2) {
                passwordReset(id);
            } else if (choice == 3) {
                viewProfile(id);
            } else if (choice == 4) {
                getSalarySlip(id);
            } else if (choice == 5) {
                return;
            } else {
                System.out.println("Invalid Choice ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static void getSalarySlip(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader("salary.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 7)
                    continue;
                if (Integer.parseInt(data[0]) == id) {
                    System.out.println("================================================");
                    System.out.println("               SALARY SLIP");
                    System.out.println("================================================");
                    System.out.println("Employee ID       : " + data[0]);
                    System.out.println("Present Days      : " + data[1]);
                    System.out.println("Base Salary       : " + data[2]);
                    System.out.println("HRA               : " + data[3]);
                    System.out.println("Medical Allowance : " + data[4]);
                    System.out.println("Loss in Pay       : " + data[5]);
                    System.out.println("------------------------------------------------");
                    System.out.println("NET PAYMENT       : " + data[6]);
                    System.out.println("================================================");
                    return;
                }
            }
            System.out.println("Employee record not found.");
        } catch (Exception e) {
            System.out.println("Error generating pay slip.");
        }
    }

    public static void markAttendance(int id) {
        LocalDateTime now = LocalDateTime.now();
        String todayDate = now.format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        try (BufferedReader br = new BufferedReader(
                new FileReader("attendance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 2)
                    continue;
                if (Integer.parseInt(data[0]) == id &&
                        data[1].startsWith(todayDate)) {

                    System.out.println(
                            "Attendance already marked today.");
                    return;
                }
            }
        } catch (java.io.FileNotFoundException e) {
            // attendance.txt doesn't exist yet
        } catch (Exception e) {
            System.out.println(
                    "Error checking previous attendance.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("attendance.txt", true))) {
            String dateTime = now.format(
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy HH:mm:ss"));
            bw.write(id + "|" + dateTime);
            bw.newLine();
            System.out.println(
                    "Attendance marked successfully.");
        } catch (Exception e) {
            System.out.println(
                    "Error! Attendance not marked.");
        }
    }

    public static void passwordReset(int id) {
        System.out.print("Enter NEW password : ");
        String newPassword = sc.next();
        String hashedPassword = hashPassword(newPassword);
        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (id == Integer.parseInt(data[0])) {
                    records.add(id + "|" + data[1] + "|" + hashedPassword + "|" + data[3]);
                } else {
                    records.add(line);
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading records.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("empRecord.txt"))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Error updating password.");
        }
    }

    public static void viewProfile(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 4)
                    continue;
                if (Integer.parseInt(data[0]) == id) {
                    System.out.println("================================================");
                    System.out.println("               EMPLOYEE PROFILE");
                    System.out.println("================================================");
                    System.out.println("Employee ID : " + data[0]);
                    System.out.println("Name        : " + data[1]);
                    System.out.println("Role        : " + data[3]);
                    System.out.println("Attendance  : " + attendanceCount(id) + " Days");
                    System.out.println("================================================");
                    return;
                }
            }
            System.out.println("Employee profile not found.");
        } catch (Exception e) {
            System.out.println("Error retrieving profile.");
        }
    }

    public static int attendanceCount(int id) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 0 &&
                        Integer.parseInt(data[0]) == id) {

                    count++;
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return count;
    }

    public static void postAdminLogin() {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("[1] Add Employee record");
            System.out.println("[2] Delete employee record");
            System.out.println("[3] Update Employee record");
            System.out.println("[4] Check Employee's Attendance");
            System.out.println("[5] List all employees");
            System.out.println("[6] Search an Employee");
            System.out.println("[7] Update Salary");
            System.out.println("[8] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                addRecord();
            } else if (choice == 2) {
                deleteRecord();
            } else if (choice == 3) {
                updateRecord();
            } else if (choice == 4) {
                attendanceCheck();
            } else if (choice == 5) {
                listEmployees();
            } else if (choice == 6) {
                searchEmployee();
            } else if (choice == 7) {
                updateSalary();
            } else if (choice == 8) {
                programExit();
            } else {
                System.out.println("Invalid Input! Please re-enter your choice.");
            }
        }
    }

    public static void searchEmployee() {
        int num;
        while (true) {
            System.out.print("Enter Employee ID : ");
            num = sc.nextInt();
            if (!empIdExist(num)) {
                System.out.println("This employee does not exist in records.");
                return;
            }
            break;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 4)
                    continue;
                if (Integer.parseInt(data[0]) == num) {
                    System.out.println("================================================");
                    System.out.println("               EMPLOYEE PROFILE");
                    System.out.println("================================================");
                    System.out.println("Employee ID : " + data[0]);
                    System.out.println("Name        : " + data[1]);
                    System.out.println("Role        : " + data[3]);
                    System.out.println("Attendance  : " + attendanceCount(num) + " Days");
                    System.out.println("================================================");
                    return;
                }
            }
            System.out.println("Employee profile not found.");
        } catch (Exception e) {
            System.out.println("Error retrieving profile.");
        }
    }

    public static void updateSalary() {
        ArrayList<String> empId = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                empId.add(data[0]);
            }
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
            return;
        }
        ArrayList<String> salary = new ArrayList<>();
        for (String currentEmpId : empId) {
            System.out.println();
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("Entering records for EMPLOYEE ID : " + currentEmpId);
            System.out.println();
            System.out.print("Enter Number of present days : ");
            int presentDays = sc.nextInt();
            while (presentDays < 0 || presentDays > 30) {
                System.out.println("Invalid Days!");
                presentDays = sc.nextInt();
            }
            System.out.print("Enter Base Salary : ");
            int baseSalary = sc.nextInt();
            int hra = (baseSalary * 30) / 100;
            int medicalAllow = (baseSalary * 10) / 100;
            int loss = (baseSalary / 30) * (30 - presentDays);
            int totalSalary = (baseSalary + hra + medicalAllow) - loss;
            salary.add(currentEmpId + "|" + presentDays + "|" + baseSalary + "|" + hra + "|" + medicalAllow + "|" + loss
                    + "|" + totalSalary);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("salary.txt"))) {
            for (String salaryRecord : salary) {
                bw.write(salaryRecord);
                bw.newLine();
            }
            System.out.println("Salary updated Successfully !");
            return;
        } catch (Exception e) {
            System.out.println("Salary not updated ! Try again after sometime.");
        }
    }

    public static boolean empIdExist(int n) {
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
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
            System.out.println("Error Occurred ! Try after sometime.");
            return false;
        }
    }

    public static void addRecord() {
        int num;
        String name;
        while (true) {
            System.out.print("Enter EMPLOYEE ID : ");
            num = sc.nextInt();
            if (empIdExist(num)) {
                System.out.println("This employee already exists in records.");
                continue;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter NAME : ");
        name = sc.nextLine();
        System.out.print("Enter EMPLOYEE password : ");
        String password = sc.next();
        sc.nextLine();
        String hashedPassword = hashPassword(password);
        System.out.print("Enter EMPLOYEE Role : ");
        String role = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("empRecord.txt", true))) {
            bw.write(num + "|" + name + "|" + hashedPassword + "|" + role);
            bw.newLine();
            System.out.println("Employee Record added successfully!");
        } catch (Exception e) {
            System.out.println("Error while saving record!");
        }
    }

    public static void deleteRecord() {
        int num;
        while (true) {
            System.out.print("Enter Employee ID : ");
            num = sc.nextInt();
            if (!empIdExist(num)) {
                System.out.println("This employee does not exist in records.");
                return;
            }
            break;
        }
        ArrayList<String> record = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                try {
                    if (data.length > 0 && Integer.parseInt(data[0]) == num) {
                        continue;
                    }
                    record.add(line);
                } catch (Exception e) {
                    record.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading records file!");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("empRecord.txt"))) {
            for (String rec : record) {
                bw.write(rec);
                bw.newLine();
            }
            System.out.println("Record deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error updating records file!");
        }
    }

    public static void updateRecord() {
        int oldNumber;
        while (true) {
            System.out.print("Enter EMPLOYEE ID to update : ");
            oldNumber = sc.nextInt();
            if (!empIdExist(oldNumber)) {
                System.out.println("This employee does not exist in your records.");
                return;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter NEW ROLE : ");
        String newRole = sc.nextLine().trim();
        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (oldNumber == Integer.parseInt(data[0])) {
                    records.add(oldNumber + "|" + data[1] + "|" + data[2] + "|" + newRole);
                } else {
                    records.add(line);
                }
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any employee saved yet.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading records.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("empRecord.txt"))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Employee role updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating records.");
        }
    }

    public static void attendanceCheck() {
        System.out.println("------------------------------------------------------");
        int id;
        while (true) {
            System.out.print("Enter EMPLOYEE ID to update : ");
            id = sc.nextInt();
            if (!empIdExist(id)) {
                System.out.println("This employee does not exist in your records.");
                return;
            }
            break;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            int count = 1;

            boolean found = false;
            System.out.println("======================================================");
            System.out.println("               ATTENDANCE (PRESENT) RECORD OF " + id);
            System.out.println("======================================================");

            System.out.printf("%-8s %-20s%n",
                    "Sr No.", "Date and Time");
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (id == Integer.parseInt(data[0])) {
                    found = true;
                    if (data.length < 2)
                        continue;
                    found = true;
                    System.out.printf("%-8d  %-20s%n",
                            count, data[1]);
                    count++;
                }
            }
            if (!found) {
                System.out.println("No Attendance Record Found !");
            }
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Error opening record File ! Please try after sometime.");
        }
    }

    public static void listEmployees() {
        System.out.println("==============================================================");
        System.out.println("                    EMPLOYEE RECORDS");
        System.out.println("==============================================================");
        System.out.printf("%-10s %-25s %-20s%n",
                "ID", "NAME", "ROLE");
        System.out.println("--------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("empRecord.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 4)
                    continue;

                found = true;
                System.out.printf("%-10s %-25s %-20s%n",
                        data[0],
                        data[1],
                        data[3]);
            }
            if (!found) {
                System.out.println("No employee records found.");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("No employee records available.");
        } catch (Exception e) {
            System.out.println("Error reading employee records.");
        }
        System.out.println("==============================================================");
    }

    public static void userSide() {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("[1] Login as EMPLOYEE");
            System.out.println("[2] Login as ADMIN");
            System.out.println("[3] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                empLogin();
            } else if (choice == 2) {
                System.out.print("Enter ADMIN ID : ");
                int accNo = sc.nextInt();
                if (accNo == 192837465) { // Secret Admin ID
                    postAdminLogin();
                    return;
                } else {
                    System.out.println("Access Denied!");
                }
            } else if (choice == 3) {
                programExit();
            } else {
                System.out.println("Invalid Input ! Please enter a valid input.");
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

}